import kotlin.concurrent.thread

/*
* 死锁实现方案
* */
fun main() {
    val object1 = Any()
    val object2 = Any()

    val thread1 = Thread {
        synchronized(object1) {
            println("thread 1 has object1")
            Thread.sleep(5000)
            synchronized(object2) {
                println("thread 1 has object1 and object2")
            }
        }
    }

    val thread2 = Thread {
        synchronized(object2) {
            println("thread 2 has object2")
            Thread.sleep(5000)
            synchronized(object1) {
                println("thread 2 has object1 and object2")
            }
        }
    }
    thread1.start()
    thread2.start()
    // 调用 join 确保 main 所在线程等待两个子线程执行完成，否则会提前结束没有打印内容
    // 不调用也不会立即结束，这是因为，即使 main 函数的代码执行完毕了（也就是到达了 fun main() { ... } 的末尾），Java 虚拟机 (JVM) 默认情况下会等待所有的 非守护线程 (non-daemon threads) 执行完毕后才会退出。
    thread1.join()
    thread2.join()
}