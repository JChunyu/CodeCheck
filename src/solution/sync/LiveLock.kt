package solution.sync

import java.util.concurrent.locks.ReentrantLock

// 当两个线程互相持有了对方需要的资源，请求对方资源阻塞后，会释放已占有的资源。然后重新申请资源，
// 再次请求对方的资源，继续阻塞释放已占有的资源。可能会发生多次循环，进而导致资源的浪费，这就是活锁的现象。

// 解决办法：释放已占有资源时采用随机时间释放，增加谦让已占有资源的随机性。
class LiveLock {

    class ThreadA : Thread() {
        override fun run() {
            while (true) {
                lockB.lock()
                sleep(1000)
                try {
                    if (lockA.tryLock()) {
                        println("B Lock in Thread A")
                    } else {
                        println("B Lock in Thread A failed")
                    }
                } finally {
                    lockB.unlock()
                }
            }
        }
    }

    class ThreadB: Thread() {
        override fun run() {
            while (true) {
                lockA.lock()
                sleep(1000)
                try {
                    if (lockB.tryLock()) {
                        println("A Lock in Thread B")
                    } else {
                        println("A Lock in Thread B failed")
                    }
                } finally {
                    lockA.unlock()
                }
            }
        }
    }

    companion object {
        var lockA = ReentrantLock()
        var lockB = ReentrantLock()

        @JvmStatic
        fun main(args: Array<String>) {
            var threadA = ThreadA()
            var threadB = ThreadB()
            threadA.start()
            threadB.start()
        }
    }
}