package leetcode

/*
在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。

2, 3, 4,
3, 4, 3
 0 1 2 3 4
[1,2,3,4,5]
[3,4,5,1,2]
* */
class Q134 {

    // timeout
    fun canCompleteCircuit2(gas: IntArray, cost: IntArray): Int {
        var i = 0
        while (i < gas.size) {
            var cur = 0
            var needNext = false
            // 假设从 i 出发
            for (j in i until gas.size) {
                cur += gas[j]
                cur -= cost[j]
                if (cur < 0) {
                    needNext = true
                    break
                }
            }
            if (!needNext) {
                for (j in 0 until i) {
                    cur += gas[j]
                    cur -= cost[j]
                    if (cur < 0) {
                        break
                    }
                }
            }
            if (cur >= 0) {
                return i
            } else {
                i++
            }
        }
        return -1
    }

    // 前提1：gas 之和一定大于 cost 之和
    //
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var minBalance = 0 // 最小剩余油量 可能小于 0
        var minIndex = 0  // 最小油量的位置
        var balance = 0   // 当前剩余油量
        for (i in gas.indices) {
            balance = balance + gas[i] - cost[i]
            if (balance < minBalance) { // 如果当前油量小于最小油量，
                minBalance = balance
                minIndex = i + 1
            }
        }
        return if (balance >= 0) return minIndex else -1
    }
}


fun main() {
    Q134().canCompleteCircuit(intArrayOf(1,2,3,4,5), intArrayOf(3,4,5,1,2))
}
