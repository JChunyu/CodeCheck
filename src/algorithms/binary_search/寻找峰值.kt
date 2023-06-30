package algorithms.binary_search

class FindPeakElement {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.isEmpty()) return -1
        if (nums.size == 1) return 0
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = (right - left) / 2 + left
            val dleft = mid - 1
            val dright = mid + 1
            val prev = if (dleft < 0 || dleft >= nums.size) {
                Int.MIN_VALUE
            } else {
                nums[dleft]
            }
            val next = if (dright < 0 || dright >= nums.size) {
                Int.MIN_VALUE
            } else {
                nums[dright]
            }

            if (nums[mid] > prev && nums[mid] > next) {
                return mid
            } else if (nums[mid] >= prev) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return -1
    }
}

fun main() {
    val n = FindPeakElement().findPeakElement(intArrayOf(-2147483648,-2147483647))
    print(n)
}