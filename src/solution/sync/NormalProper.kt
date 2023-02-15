package solution.sync

class NormalProper {
    var value = 0
    var a = 0
    var b = 0

    fun main() {
        val thread1 = Thread {
            a = value
            println(Thread.currentThread())
        }
        value++
        val thread2 = Thread {
            b = value
            println(Thread.currentThread())
        }
        thread1.start()
        thread2.start()
        println(a)
        println(b)
        println(value)
    }
}

fun main() {
    NormalProper().main()
}