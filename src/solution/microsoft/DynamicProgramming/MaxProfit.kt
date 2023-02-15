package solution.microsoft.dynamicprogramming

/*
* 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
* */
class MaxProfit {
    fun maxProfit(prices: IntArray): Int {
        var min = Int.MAX_VALUE
        var profit = 0

        prices.forEach {
            if (it < min) {
                min = it
            }
            profit = Math.max(profit, it - min)
        }
        return profit
    }
}