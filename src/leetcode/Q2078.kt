package leetcode

import kotlin.math.abs
import kotlin.math.max

/*
* 街上有 n 栋房子整齐地排成一列，
* 每栋房子都粉刷上了漂亮的颜色。
* 给你一个下标从 0 开始且长度为 n 的整数数组 colors ，其中 colors[i] 表示第  i 栋房子的颜色。
* 返回 两栋 颜色 不同 房子之间的 最大 距离。
* 第 i 栋房子和第 j 栋房子之间的距离是 abs(i - j) ，其中 abs(x) 是 x 的绝对值。
* */
class Q2078 {
    fun maxDistance(colors: IntArray): Int {
        var max = 0
        val start = 0
        val end = colors.lastIndex
        for (j in start + 1 until colors.size) {
            if (colors[start] != colors[j]) {
                max = maxOf(max, abs(j - start))
            }
        }
        for (i in 0 until end) {
            if (colors[end] != colors[i]) {
                max = maxOf(max, abs(end - i))
            }
        }
        return max
    }
}