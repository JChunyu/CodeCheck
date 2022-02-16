package binarysearch/*
* 704. 二分查找
* */
class BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val center = (left + right) / 2 // 取中间值  0 - 4   == 2 ； 0 - 5 == 2.5
            if (nums[center] == target) {
                return center
            }
            if (nums[center] > target) {
                right = center - 1

            }
            if (nums[center] < target) {
                left = center + 1
            }
        }
        return -1
    }
}
