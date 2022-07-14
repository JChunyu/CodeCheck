package binarysearch

/*
* 有序数组按排序插入元素
* */
class SearchInsert {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var min = 0
        var max = nums.size - 1
        while (min <= max) {
            val center = min + (max - min) / 2
            when {
                nums[center] == target -> {
                    return center
                }
                nums[center] > target -> {
                    max = center - 1
                }
                else -> {
                    min = center + 1
                }
            }
        }
        return min
    }
}