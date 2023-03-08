package algorithms.binary_search

class SearchRotateArray {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var temp = nums[0]
        var index = -1

        while (left <= right) {
            val mid = (right - left) / 2 + left
            if (nums[mid] >= temp) {
                temp = nums[mid]
                left = mid + 1
            } else {
                temp = nums[mid]
                right = mid - 1
                index = mid
            }
        }

        if (target >= nums[0]) {
            // 0  - index
            left = 0
            right = index

        } else {
            // index - nums.size - 1
            left = index
            right = nums.size - 1
        }

        if (index == -1) {
            left = 0
            right = nums.size - 1
        }

        while (left <= right) {
            val mid = (right - left) / 2 + left
            if (nums[mid] == target) {
                return mid
            } else if (target > nums[mid]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return -1
    }
}

fun main() {
    val res = SearchRotateArray().search(intArrayOf(1, 3), 3)
    println(res)
}