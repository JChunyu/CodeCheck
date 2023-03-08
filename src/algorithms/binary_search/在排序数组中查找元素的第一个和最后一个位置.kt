package algorithms.binary_search

class SearchRange {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf(-1, -1)
        val left = 0
        val right = nums.size - 1
        val index = binarySearch(nums, target, left, right)
        if (index == -1) return intArrayOf(-1, -1)
        var i = index
        while (i >= 0 && nums[i] == target) {
            i--
        }
        var j = index
        while (0 <= j && j < nums.size && nums[j] == target) {
            j++
        }

        return intArrayOf(i + 1, j - 1)
    }

    private fun binarySearch(nums: IntArray, target: Int, left: Int, right: Int): Int {
        if (left > right) return -1
        val point = (right - left) / 2 + left
        val cur = nums[point]
        return when {
            target == cur -> {
                point
            }
            target < cur -> {
                binarySearch(nums, target, left, point - 1)
            }
            else -> {
                binarySearch(nums, target, point + 1, right)
            }
        }
    }

    fun searchRange2(nums: IntArray, target: Int): IntArray {
        val left = binarySearch2(nums, target, true)
        val right = binarySearch2(nums, target, false) -1
        if (left <= right && right < nums.size && nums[left] == target && nums[right] == target) {
            return intArrayOf(left, right)
        }
        return intArrayOf(-1, -1)
    }

    private fun binarySearch2(nums: IntArray, target: Int, lower: Boolean): Int {
        var left = 0
        var right = nums.size - 1
        var ans = nums.size
        while (left <= right) {
            val mid = (right - left) / 2 + left
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1
                ans = mid
            } else {
                left = mid + 1
            }
        }
        return ans
    }
}

fun main() {
    val n = SearchRange().searchRange(intArrayOf(1), 1)
    n.forEach {
        println(it)
    }
}