package javatest

class B {
    val numberA = 100
    val numberC: Int? = 100

    fun checkEquals() {
        val numberB = 100
        println(numberA == numberB)
        println(numberA === numberB)
    }

    val stingA = "A"

    fun checkEqualString() {
        val stringB = "A" //
        println(stingA == stringB)          // true
        println(stingA === stringB)         // false
        println(stingA.equals(stringB))     // true
    }

    override fun equals(other: Any?): Boolean {
        return false
    }
}

fun main() {
    val b = B()
    val c = b

    println(b == c)
    println(b === c)
    println(b.equals(c))
}