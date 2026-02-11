package leetcode

import kotlin.math.min


class Q31 {
    fun nextPermutation(nums: IntArray) {
        if (nums.size < 2) return

        fun swap(i: Int, j: Int) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        }

        fun reverse(start: Int, end: Int) {
            var l = start
            var r = end
            while (l < r) {
                swap(l, r)
                l++
                r--
            }
        }
        var index = nums.lastIndex - 1
        // 从右向左，前大于等于后一个元素，继续向前
        while (index >= 0 && nums[index] >= nums[index + 1]) index--
        // 若存在升序，说明存在更大值
        if (index >= 0) {
            var j = nums.lastIndex
            // j 从最右侧向前查找大于当前位置的最小值
            while (nums[j] <= nums[index]) j--
            swap(index, j)
        }
        // 最后反转后续的节点
        reverse(index + 1, nums.lastIndex)
    }
}

