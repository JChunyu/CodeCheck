package algorithms

import java.util.Objects
import java.util.concurrent.locks.LockSupport

class ThreadProj {

    /*
    * 按序打印
    * */
    fun alternatePrinting() {
        var i = 0
        var flag = false
        val lock = Object()
        val thread1 = Thread {
            while (i < 100) {
                synchronized(lock) {
                    if (flag) {
                        i++
                        println("A - $i")
                        lock.notify()
                        flag = false
                    } else {
                        lock.wait()
                    }
                }
            }
        }
        val thread2 = Thread {
            while (i < 100) {
                synchronized(lock) {
                    if (!flag) {
                        i++
                        println("B - $i")
                        lock.notify()
                        flag = true
                    } else {
                        lock.wait()
                    }
                }
            }
        }
        thread1.start()
        thread2.start()
        thread1.join()
        thread2.join()
    }

    fun alternatePrinting2() {
        var i = 0
        var flag = true
        lateinit var thread2: Thread

        val thread1 = Thread {
            while (i < 100) {
                if (flag) {
                    i++
                    println("A - $i")
                    flag = false
                    LockSupport.unpark(thread2) // 直接使用变量 thread2
                    if (i < 100) {
                        LockSupport.park()
                    }
                } else {
                    LockSupport.park()
                }
            }
        }
        thread2 = Thread {
            while (i < 100) {
                if (!flag) {
                    i++
                    println("B - $i")
                    flag = true
                    LockSupport.unpark(thread1) // 直接使用变量 thread1
                    if (i < 100) {
                        LockSupport.park()
                    }
                } else {
                    LockSupport.park()
                }
            }
        }
        thread1.start()
        thread2.start()
        thread1.join()
        thread2.join()
    }
}

class Foo {
    @Volatile
    var tag1 = false
    @Volatile
    var tag2 = false

    @Throws(InterruptedException::class)
    fun first(printFirst: Runnable) {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run()
        tag1 = true
    }

    @Throws(InterruptedException::class)
    fun second(printSecond: Runnable) {
        while (!tag1) {
            continue
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run()
        tag2 = true
    }

    @Throws(InterruptedException::class)
    fun third(printThird: Runnable) {
        while (!tag2) {
            continue
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run()
    }
}

fun main() {
    val proj = ThreadProj()
    proj.alternatePrinting2()
}