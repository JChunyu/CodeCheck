package array

class NO17MaxN {
    fun printNumbers(n: Int): IntArray {
        val max = getMax(n)
        val array = IntArray(max - 1)
        for (i in 1 until max) {
            array[i - 1] = i
        }
        return array
    }

    private fun getMax(x: Int): Int {
        if (x == 1) return 1
        return getMax(x - 1) * 10
    }
}

fun main() {
    val maxN = NO17MaxN().printNumbers(3)
}