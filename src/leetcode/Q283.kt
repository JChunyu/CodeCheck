package leetcode

fun moveZeroes(nums: IntArray) {
    var index = 0

    nums.forEachIndexed { i, value ->
        if (value != 0) {
            nums[index] = value
            if (index != i) {
                nums[i] = 0
            }
            index++
        }
    }
}