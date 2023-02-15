package solution.lock

import java.util.*
import java.util.concurrent.locks.LockSupport

class LockSupportDemo {
    fun check() {
        val thread1 = Thread {
            Thread.sleep(1000)
            println("thread1 start + ${Date(System.currentTimeMillis())}")
            LockSupport.park()
            println("thread1 end +  ${Date(System.currentTimeMillis())}")
        }

        val thread2 = Thread {
            println("thread2 start +  ${Date(System.currentTimeMillis())}")
            LockSupport.unpark(thread1)
            println("thread2 end +  ${Date(System.currentTimeMillis())}")
        }
        thread1.start()
        thread2.start()
    }


}

fun main() {
    LockSupportDemo().check()
}