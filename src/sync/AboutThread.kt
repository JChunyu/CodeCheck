package sync

class AboutThread {

}

fun main() {
//    // new
//    val thread = Thread(object : Runnable {
//        override fun run() {
//            TODO("Not yet implemented")
//        }
//    })
//
//    // runnable
//    thread.start()
//
//    // timed waiting
//    Thread.sleep(2000)
//
//    // wait
//    thread.join()
//
//    // block
//    val a = Any()
//    val blockThread = Thread {
//        synchronized(a) {
//            // TODO
//        }
//    }
//    blockThread.start()
//    // 当 a 持有其他锁时，当前 blockThread 无法获取 a 的权限，此时处于阻塞状态

    // 中断线程
    val interceptThread = InterceptThread()
    interceptThread.start()
    Thread.sleep(1000)
    interceptThread.interrupt() // 中断 interceptThread 线程，仅是发送了一个中断请求

    // 中断线程 2 使用 Volatile flag
//    val intercept2Thread = Intercept2Thread()
//    intercept2Thread.start()
//    Thread.sleep(1000)
//    intercept2Thread.running = false
    println("end")
}

class InterceptThread: Thread() {
    override fun run() {
        var n = 0
        while (!isInterrupted) {
            n++
            println(n)
        }
    }
}

class  Intercept2Thread: Thread() {
    @Volatile
    var running: Boolean = true
    override fun run() {
        var n = 0
        while (running) {
            n++
            println(n)
        }
    }
}

