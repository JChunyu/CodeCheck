package javatest

class Outter {
    private fun printOut() {
        println("Out")
    }

    inner class Inn {

        fun setListener(r: Runnable) {
            r.run()
        }

        fun printInn() {
            setListener(object : Runnable {
                override fun run() {
                    printOut()
                }
            })
        }
    }
}

fun main() {
    val a: Int = 100
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    val b: Int = 10000
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b


    println(boxedA === anotherBoxedA) // true
    println(boxedA == anotherBoxedA) // true
    println(boxedB === anotherBoxedB) // false
    println(boxedB == anotherBoxedB) // false
}
