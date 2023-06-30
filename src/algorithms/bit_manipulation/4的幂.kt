package algorithms.bit_manipulation

/*
*
* */
class IsPowerOfFour {
    fun isPowerOfFour(n: Int): Boolean {
        return n > 0 && n and (n - 1) == 0 && (n and 0b101010101010101010101010101010) == 0
    }
}