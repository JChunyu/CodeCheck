package solution.doublepointer
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
* - 1.
* */
class SortedSquared {
    fun sortedSquares(nums: IntArray): IntArray {
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