package algorithms.two_point

import java.util.concurrent.Semaphore


class SemaphoreProj {
    private var semaphore = Semaphore(1)

    private val thread1 = Thread {
        semaphore.acquire(2)
        println("thread1 finish")
        semaphore.release()
    }

    private val thread2 = Thread {
        semaphore.acquire()
        println("thread2 finish")
        semaphore.release(2)
    }

    fun test() {
        thread2.start()
        thread1.start()
    }
}

fun main() {
    SemaphoreProj().test()
}