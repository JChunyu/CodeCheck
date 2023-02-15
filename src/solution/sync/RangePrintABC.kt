package solution.sync

class RangePrintABC {
    companion object {
        var lockA = Any()
        var lockB = Any()
        var lockC = Any()

        @JvmStatic
        fun main(args: Array<String>) {
            RangePrintABC().run()
        }
    }

    fun run() {
        val threadA = ThreadA()
        val threadB = ThreadB()
        val threadC = ThreadC()
        threadA.start()
        threadB.start()
        threadC.start()
    }

    class ThreadA: Thread() {
        override fun run() {
            while (true) {
                // 持有 A ， 等待 C 锁释放
                synchronized(lockA) {
                    synchronized(lockC) {
                        sleep(1000)
                        println("A")
                    }
                }
                sleep(1000)
            }
        }
    }
    class ThreadB: Thread() {
        override fun run() {
            while (true) {
                // 持有 B，等待 A
                synchronized(lockB) {
                    synchronized(lockA) {
                        sleep(1000)
                        println("B")
                    }
                }
                sleep(1000)
            }
        }
    }
    class ThreadC: Thread() {
        override fun run() {
            while (true) {
                // 持有 C，等待 B
                synchronized(lockC) {
                    synchronized(lockB) {
                        sleep(1000)
                        println("C")
                    }
                }
                sleep(1000)
            }
        }
    }
}