package algorithms.bit_manipulation

class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        var ans = 0
        nums.forEach {
            ans = it xor ans
        }
        return 0
    }
}