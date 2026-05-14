package leetcode

/*
给你两个整数数组 source 和 target ，长度都是 n 。
还有一个数组 allowedSwaps ，其中每个 allowedSwaps[i] = [ai, bi] 表示你可以交换数组 source 中下标为 ai 和 bi（下标从 0 开始）的两个元素。
注意，你可以按 任意 顺序 多次 交换一对特定下标指向的元素。

相同长度的两个数组 source 和 target 间的 汉明距离 是元素不同的下标数量。
形式上，其值等于满足 source[i] != target[i] （下标从 0 开始）的下标 i（0 <= i <= n-1）的数量。

在对数组 source 执行 任意 数量的交换操作后，返回 source 和 target 间的 最小汉明距离 。
* */
class Q1755 {
    fun minimumHammingDistance(source: IntArray, target: IntArray, allowedSwaps: Array<IntArray>): Int {
        val n = source.size
        val pathMap = hashMapOf<Int, Int>()
        for (pair in allowedSwaps) {
            pathMap[pair[0]] = pair[1]
        }

        val indexSet = hashSetOf<Int>()
        val group = arrayListOf<IntArray>()
        pathMap.forEach {
            if (!indexSet.contains(it.key)) {
                val list = arrayListOf<Int>()
                while (!indexSet.contains(it.key)) {
                    list.add(it.key)
                    indexSet.add(it.key)
                }
                group.add(list.toIntArray())
            }
        }

        group.forEach { array ->
            val groupMap = hashMapOf<Int, Int>()
            array.forEach {
                if (!groupMap.contains(target[it])) {
                    groupMap[target[it]] = 1
                } else {
                    groupMap[target[it]] = target[it] + 1
                }
            }
            array.forEach {

            }
        }

        return 0
    }
}