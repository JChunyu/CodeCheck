package algorithms.binary_search

class FindMin {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        var ans = 0
        var fir = nums[0]
        while (left <= right) {
            val mid = (right - left) / 2 + left
            if (nums[mid] >= fir) {
                left = mid + 1
                fir = nums[mid]
            } else {
                right = mid - 1
                fir = nums[mid]
                ans = mid
            }
        }
        return nums[ans]
    }
}