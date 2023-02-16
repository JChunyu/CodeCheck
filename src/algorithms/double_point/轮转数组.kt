package algorithms.double_point

/*
* 189.轮转数组
* 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。

输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右轮转 1 步: [7,1,2,3,4,5,6]
向右轮转 2 步: [6,7,1,2,3,4,5]
向右轮转 3 步: [5,6,7,1,2,3,4]
*
* */

class RotateList {
    fun rotate2(nums: IntArray, k: Int) {
        val rawK = if (k > nums.size) {
            k % nums.size
        } else {
            k
        }
        val newStartIndex = nums.size - rawK
        val left = nums.copyOfRange(0, newStartIndex)
        val right = nums.copyOfRange(newStartIndex, nums.size)
        var i = 0
        right.forEach {
            nums[i++] = it
        }
        left.forEach {
            nums[i++] = it
        }
    }

    fun rotate(nums: IntArray, k: Int): Unit {
        val ko = if (k > nums.size) {
            k % nums.size
        } else {
            k
        }
        var index = nums.size - ko
        val left = nums.copyOfRange(0, index)
        val right = nums.copyOfRange(index, nums.size)
        var cur = 0
        right.forEach {
            nums[cur] = it
            cur++
        }
        left.forEach {
            nums[cur] = it
            cur++
        }
        nums.forEach {
            print(it)
        }
    }
}

fun main() {
    RotateList().rotate2(intArrayOf(1, 2, 3, 4, 5, 6, 7),  3)
}