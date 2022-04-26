package array

import java.lang.StringBuilder

class Solution {
//    给定一个二进制数组，计算其中最大连续1的个数。
//
//    示例
//
//    输入: [1, 1, 0, 1, 1, 1]
//
//    输出: 3
//
//    解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
//
//    要求：时间复杂度O(n)，空间复杂度O(1)
//
//    注意：输入的数组只包含 0 和 1
    fun maxOne(array: IntArray): Int {
        var res = 0
        var j = 0
        for (i in array.indices) {
            if (array[i] == 1) {
                j = i
            }
            while (j < array.size && array[j] == 1) {
                j++
                res = Math.max(res, j - i)
            }
        }
        return res
    }

    fun maxOne2(array: IntArray): Int {
        var s = StringBuilder()
        array.forEach {
            s.append(it)
        }
        val res = s.split('0')

        var len = Int.MIN_VALUE
        res.forEach {
            len = Math.max(len, it.length)
        }
        return len
    }

    fun maxOne3(array: IntArray): Int {
        var res = 0
        var last = 0
        var i = 0
        while (i < array.size) {
            if (array[i] == 1) {
                res++
                last = Math.max(last, res)
            } else {
                res = 0
            }
            i++
        }
        return last
    }
}

fun main() {
    println(Solution().maxOne(intArrayOf(1,1,1,0,1)))
    println(Solution().maxOne2(intArrayOf(1,1,1,0,1)))
    println(Solution().maxOne3(intArrayOf(1,1,1,0,1)))
}