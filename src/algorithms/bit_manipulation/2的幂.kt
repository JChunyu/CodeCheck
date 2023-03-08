package algorithms.bit_manipulation


class IsPowerOfTwo {
    fun isPowerOfTwo(n: Int): Boolean {
        if (n < 2) return false
        val r = n and (n - 1)
        return r == 0
    }
}