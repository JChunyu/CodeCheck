import kotlin.math.cos

/*
* 746. 使用最小花费爬楼梯
* */
class MinCostClimbingStairs {
    fun minCostClimbingStairs(cost: IntArray): Int {
        // 终止条件，最后一步为 1 或 2
        // 状态方程 min(x) = min(m((x - 1) + cost[x - 1]) , m(x - 2) + cost[x -2])
        val n = cost.size
        val preCost = IntArray(n + 1)
        preCost[0] = 0
        preCost[1] = 0
        for (i in 2..cost.size) {
            preCost[i] = Math.min(preCost[i - 1] + cost[ i - 1], preCost[i - 2] + cost[i - 2])
        }
        return preCost[cost.size]
    }
}