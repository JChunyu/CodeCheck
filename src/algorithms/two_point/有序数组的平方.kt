package algorithms.two_point
/*
* 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
*
* 1 <= nums.length <= 104
* -104 <= nums[i] <= 104
* nums 已按 非递减顺序 排序
* 请你设计时间复杂度为 O(n) 的算法解决本问题
* */
class SortedSquares {
    fun sortedSquares(nums: IntArray): IntArray {
        if (nums.size == 0) return intArrayOf()
        // x
        var i = 0
        while (i < nums.size && nums[i] < 0) {
            i++
        }
        // 0 -> i -1 小于 0
        // i -> nums.size 大于等于 0
        val res = IntArray(nums.size)
        var left = i - 1
        var right = i
        var j = 0

        while (left >= 0 || right < nums.size) {
            if (left < 0 && right <= nums.size -1) {
                res[j] = nums[right] * nums[right]
                j++
                right++
                continue
            }
            if (right > nums.size -1 && left >= 0) {
                res[j] = nums[left] * nums[left]
                j++
                left--
                continue
            }
            if (-nums[left] < nums[right]) {
                res[j++] = nums[left] * nums[left]
                left--
            } else {
                res[j++] = nums[right] * nums[right]
                right++
            }
        }
        return res
    }

    /*
    * 977. 有序数组的平方排序
    *
    * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
    * 要求时间复杂度 n
    *
    * 思路
    * - 取绝对值，快速排序，再平方，时间复杂度 3n
    * - 取绝对值同时进行平方，最后快排 2n
    * - 双指针，快排
    * */
    fun sortedSquares2(nums: IntArray): IntArray {
        var result = IntArray(nums.size)
        // 分割成2个数组, 如若无负数，返回  -1
        val index = nums.indexOfFirst {
            it >= 0
        }

        if (index == -1) {
            return if (nums.first() >= 0) {
                nums.map {
                    it * it
                }.toIntArray()
            } else {
                nums.map {
                    it * it
                }.reversed().toIntArray()
            }
        }

        val lefts = nums.copyOfRange(0, index).map {
            it * it
        }
        val rights = nums.copyOfRange(index, nums.size).map {
            it * it
        }
        var current = 0
        var lPoint = lefts.size - 1
        var rPoint = 0

        while (current < nums.size) {
            if (lPoint < 0) {
                result[current] = rights[rPoint]
                rPoint++
                current++
                continue
            }
            if (rPoint >= rights.size) {
                result[current] = lefts[lPoint]
                lPoint--
                current++
                continue
            }
            if (lefts[lPoint] <= rights[rPoint]) {
                result[current] = lefts[lPoint]
                lPoint--
            } else {
                result[current] = rights[rPoint]
                rPoint++
            }
            current++
        }
        return result
    }
}



fun main() {
    val s = SortedSquares().sortedSquares(intArrayOf(-3, -1, 0, 6, 9))
    s.forEach { println(it) }
}
