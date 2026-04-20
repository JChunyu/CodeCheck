package solution.sync

import java.util.concurrent.Semaphore
/*
* 使用 3 个 Semaphore 控制 3 个线程按 A -> B -> C 的顺序循环打印。
*
* Semaphore 可以理解为“许可证计数器”：
* 1. acquire()：尝试获取一个许可证。
*    - 如果当前许可证数量 > 0，则获取成功，数量减 1，线程继续执行。
*    - 如果当前许可证数量 == 0，则当前线程阻塞，直到别的线程 release()。
* 2. release()：归还/增加一个许可证，数量加 1。
*    - release() 不要求必须是刚刚 acquire() 的同一个线程调用。
*    - 当有线程因为 acquire() 在等待时，release() 会让等待线程有机会继续执行。
*
* 本例中的工作方式：
* - semA 初始为 1，表示 A 线程一开始可以直接执行。
* - semB、semC 初始为 0，表示 B、C 线程一开始必须先等待。
* - A 线程执行时先 semA.acquire()，打印 A，然后 semB.release()，把“执行机会”交给 B。
* - B 线程执行时先 semB.acquire()，打印 B，然后 semC.release()，把“执行机会”交给 C。
* - C 线程执行时先 semC.acquire()，打印 C，然后 semA.release()，再把“执行机会”交还给 A。
*
* 这样 3 个线程就像接力一样，不是靠抢锁决定先后，而是靠 release() 把下一次执行资格交给指定线程，
* 因此可以稳定得到 ABCABCABC... 的输出顺序。
* */
class RangePrintABC {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            RangePrintABC().run()
        }
    }

    private val semA = Semaphore(1)
    private val semB = Semaphore(0)
    private val semC = Semaphore(0)

    // 方案二（wait/notify）使用的共享锁和轮次状态。
    @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
    private val monitor = Object()
    private var turn = 'A'

    fun run() {
        Thread {
            while (true) {
                semA.acquire()
                println("A")
                semB.release()
            }
        }.start()

        Thread {
            while (true) {
                semB.acquire()
                println("B")
                semC.release()
            }
        }.start()

        Thread {
            while (true) {
                semC.acquire()
                println("C")
                semA.release()
            }
        }.start()
    }

    /**
     * 方案二：使用 wait/notifyAll 实现按 A -> B -> C 的顺序打印。
     *
     * 核心原理（基于对象监视器 monitor）：
     * 1) synchronized(monitor)
     *    - 进入临界区前先拿到 monitor 的锁，保证检查 turn 和打印动作是串行的。
     * 2) wait()
     *    - 必须在持有 monitor 锁时调用。
     *    - 调用后当前线程会释放 monitor 锁并进入等待队列，直到被唤醒。
     * 3) notifyAll()
     *    - 也必须在持有 monitor 锁时调用。
     *    - 只负责“唤醒等待线程”，不会立刻把锁交出去；锁会在退出 synchronized 后释放。
     * 4) while 条件重检
     *    - 被唤醒线程拿到锁后必须再次判断 turn（防止虚假唤醒/被错误唤醒）。
     *
     * 执行流程：
     * - A 打印后把 turn 改为 B 并 notifyAll()；B 打印后改为 C；C 打印后改回 A。
     * - 通过“状态 turn + wait/notifyAll”完成线程间接力，而不是靠抢占执行顺序。
     */
    @Suppress("unused")
    fun runWithWaitNotify() {
        Thread {
            while (true) {
                synchronized(monitor) {
                    while (turn != 'A') {
                        try {
                            // 非本轮线程：释放锁并等待被唤醒。
                            monitor.wait()
                        } catch (_: InterruptedException) {
                            Thread.currentThread().interrupt()
                            return@Thread
                        }
                    }
                    println("A")
                    turn = 'B'
                    // 唤醒等待线程；真正释放锁发生在退出 synchronized 之后。
                    monitor.notifyAll()
                }
            }
        }.start()

        Thread {
            while (true) {
                synchronized(monitor) {
                    while (turn != 'B') {
                        try {
                            monitor.wait()
                        } catch (_: InterruptedException) {
                            Thread.currentThread().interrupt()
                            return@Thread
                        }
                    }
                    println("B")
                    turn = 'C'
                    monitor.notifyAll()
                }
            }
        }.start()

        Thread {
            while (true) {
                synchronized(monitor) {
                    while (turn != 'C') {
                        try {
                            monitor.wait()
                        } catch (_: InterruptedException) {
                            Thread.currentThread().interrupt()
                            return@Thread
                        }
                    }
                    println("C")
                    turn = 'A'
                    monitor.notifyAll()
                }
            }
        }.start()
    }
}