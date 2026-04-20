package 字节150

import kotlin.math.max

class MaxProfitSolution2 {
    fun maxProfit(prices: IntArray): Int {
        var n = prices.size
        val dp = Array(n) {
            IntArray(2) { 0 }
        }
        dp[0][0] = 0
        dp[0][1] = -prices[0]

        for (i in 1 until prices.size) {
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
        }
        return dp[n - 1][0]
    }

    fun maxProfit2(prices: IntArray): Int {
        var profit = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1]
            }
        }
        return profit
    }
}