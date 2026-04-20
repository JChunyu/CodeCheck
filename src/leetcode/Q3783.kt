package leetcode

import kotlin.math.abs

/*
* 给你一个整数 n。
* 定义它的 镜像距离 为：abs(n - reverse(n))，
* 其中 reverse(n) 表示将 n 的数字反转后形成的整数。
* 返回表示 n 的镜像距离的整数。
* 其中，abs(x) 表示 x 的绝对值。
* */
class Q3783 {
    fun mirrorDistance(n: Int): Int {
        val reversed = reverse(n)
        return abs(reversed - n)
    }

    fun reverse(n: Int): Int {
        var value = n
        var res = 0
        while(value > 0) {
            val digit = value % 10
            value /= 10
            res = res * 10 + digit
        }
        return res
    }
}

/*
* v 52  5  0
* d  2  5
* r  2 25
* */