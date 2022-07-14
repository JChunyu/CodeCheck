class MaxPartValueInArray {
    fun maxProfit(prices: IntArray): Int {
        // 1. 确定状态
        //   - 最后一步：假设最后一天最高价卖出 prices[n-1]
        //   - 子问题: 最后一天之前也是最高价, fx-1中有最低价买入
        // 2. 边界条件
        //   - 在 n - 1之前买入
        // 3. 转移方程
        // f(x) = min(f(x - 1), price[i])
        // f0 = price[0]
        // f1 =  min(f(0), price[1])
        // f2 = min(f1, p[2])
        var max = 0
        var start = prices[0]
        for (i in 1 until prices.size) {
            start = start.coerceAtMost(prices[i])
            max = max.coerceAtLeast(prices[i] - start)
        }
        return max
    }
}