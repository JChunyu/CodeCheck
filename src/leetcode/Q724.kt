package leetcode

fun pivotIndex(nums: IntArray): Int {
    val totalSum = nums.sum()
    var leftSum = 0

    for (i in nums.indices) {
        val rightSum = totalSum - leftSum - nums[i]
        if (leftSum == rightSum) {
            return i
        }
        leftSum += nums[i]
    }

    return -1
}


