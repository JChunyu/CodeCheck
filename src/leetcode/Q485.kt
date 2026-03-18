package leetcode

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var max = 0
    var count = 0

    for (element in nums) {
        if (element == 1) {
            count++
        } else {
            count = 0
        }
        if (count >= max) {
            max = count
        }
    }
    return max
}