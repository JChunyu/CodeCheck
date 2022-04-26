package sync

class DieLock {
    // 死锁
    companion object {
        val lock1 = Any()
        val lock2 = Any()

        @JvmStatic
        fun main(args: Array<String>) {
            DieLock().lock()
        }
    }

    class ThreadA: Thread() {
        override fun run() {
            synchronized(lock1) {
                sleep(2000)
                synchronized(lock2) {
                    println("In Thread A")
                }
            }
        }
    }
    class ThreadB: Thread() {
        override fun run() {
            synchronized(lock2) {
                sleep(2000)
                synchronized(lock1) {
                    println("In Thread B")
                }
            }
        }
    }

    fun lock() {
        val threadA = ThreadA()
        val threadB = ThreadB()
        threadA.start()
        threadB.start()
    }
}

