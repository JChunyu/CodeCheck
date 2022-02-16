package binarysearch

class SearchInsert {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var min = 0
        var max = nums.size - 1
        while (min <= max) {
            var center = min + (max - min) / 2
            if (nums[center] == target) {
                return center
            } else if (nums[center] > target) {
                max = center - 1
            } else {
                min = center + 1
            }
        }
        return min
    }
}