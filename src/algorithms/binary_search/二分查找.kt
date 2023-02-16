package algorithms.binary_search

/*
* 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
* 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
* */
class BinaryFind {

    fun search(nums: IntArray, target: Int): Int {
        return search(nums, 0, nums.size - 1, target)
    }

    // 递归
    fun search(nums: IntArray, left: Int, right: Int, target: Int): Int {
        if (left > right) {
            return -1
        }
        val center = (right - left) / 2 + left
        val n = nums[center]
        return when {
            n == target -> {
                center
            }
            target < n -> {
                search(nums, left, center - 1, target)
            }
            else -> {
                search(nums, center + 1, right, target)
            }
        }
    }

    // 迭代
    fun search2(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val center = (right - left) / 2 + left
            val num = nums[center]
            if (num == target) {
                return center
            } else if (target < num) {
                right = center - 1
            } else {
                left = center + 1
            }
        }
        return -1
    }
}