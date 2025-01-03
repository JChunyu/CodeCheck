package leetcode

import kotlin.math.min

/*
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

你可以认为每种硬币的数量是无限的。

用来保存结果的 dp[amount + 1]  IntArray min()

f(amount) = f(amount - x) + if (coins.contains(x)) 1 else { f(x) }


* */

class CoinChangeSolution {
//    fun coinChange(coins: IntArray, amount: Int): Int {
//        val dp = IntArray(amount + 1)
//        for (i in 1..amount) {
//            for (j in i - 1  downTo 1) {
//                dp[i] = min(f)
//            }
//        }
//        return if (dp[amount] == 0) -1 else dp[amount]
//    }
}

//fun main() {
//    println(CoinChangeSolution().coinChange(intArrayOf(1, 5, 10), 11))
//}