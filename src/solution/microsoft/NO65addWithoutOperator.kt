package solution.microsoft

class NO65addWithoutOperator {
    fun add(a: Int, b: Int): Int {
        if (a == 0) return b
        if (b == 0) return a
        return add(a xor b, a and b shl 1)
    }
}