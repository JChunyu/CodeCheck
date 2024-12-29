package 字节150

import kotlin.math.max
import kotlin.math.min

class MaxProfitSolution {
    fun maxProfit2(prices: IntArray): Int {
        if (prices.size < 2) return 0
        var max = 0
        for (i in 0 until prices.size - 1) {
            for (j in i until prices.size) {
                max = kotlin.math.max(prices[j] - prices[i], max)
            }
        }
        return max
    }

    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0
        for (i in 0 until prices.size) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice
            }
        }
        return maxProfit
    }
}

fun main() {
    val ans = MaxProfitSolution().maxProfit(intArrayOf(2,4,1))
    println(ans)
}