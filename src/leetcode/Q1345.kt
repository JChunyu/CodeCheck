package leetcode

import java.util.ArrayDeque

/*
    给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。

    每一步，你可以从下标 i 跳到下标 i + 1 、i - 1 或者 j ：

    i + 1 需满足：i + 1 < arr.length
    i - 1 需满足：i - 1 >= 0
    j 需满足：arr[i] == arr[j] 且 i != j
    请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。

    注意：任何时候你都不能跳到数组外面。
* */
class Q1345 {
    fun minJumps(arr: IntArray): Int {
        if (arr.size <= 1) {
            return 0
        }

        val n = arr.size
        // 步骤1: 预处理，将相同值的下标存入 map
        val map = HashMap<Int, MutableList<Int>>()
        arr.forEachIndexed { index, value ->
            map.computeIfAbsent(value) { mutableListOf() }.add(index)
        }

        // 步骤2: 初始化 BFS
        val queue = ArrayDeque<Int>() // 使用 ArrayDeque 作为队列
        queue.add(0)
        val visited = BooleanArray(n) // 使用 BooleanArray 记录访问过的下标
        visited[0] = true
        var steps = 0

        // 步骤3: 开始 BFS
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            // 遍历当前层的所有节点
            for (i in 0 until levelSize) {
                val currIndex = queue.poll()

                // 如果到达终点，返回步数
                if (currIndex == n - 1) {
                    return steps
                }

                // 步骤4: 添加所有可能的下一步到队列中

                // 跳转到 j, 其中 arr[currIndex] == arr[j]
                map[arr[currIndex]]?.forEach { neighbor ->
                    if (!visited[neighbor]) {
                        visited[neighbor] = true
                        queue.add(neighbor)
                    }
                }
                // 关键优化: 处理完后立即从 map 中移除，避免重复搜索
                map.remove(arr[currIndex])

                // 跳转到 currIndex - 1
                if (currIndex - 1 >= 0 && !visited[currIndex - 1]) {
                    visited[currIndex - 1] = true
                    queue.add(currIndex - 1)
                }

                // 跳转到 currIndex + 1
                if (currIndex + 1 < n && !visited[currIndex + 1]) {
                    visited[currIndex + 1] = true
                    queue.add(currIndex + 1)
                }
            }
            steps++ // 完成一层遍历，步数加一
        }

        return -1 // 正常情况下不会到达这里
    }
}


/*

arr = [100,-23,-23,404,100,23,23,23,3,404]

work flow:
- 从末尾找最后一个数字，
- 数组找找出相同数字的坐标列表
- 找出列表最小的值，为最靠左侧的 index
- index 大于 0
- 当前位置 + 1，size + 1
- 找出列表最小的值，为最靠左侧的 index
- index 等于 0
- return size



思路
1. 先将 arr 所有的内容建立与 index 的映射关系 <int: array[int]>,  key 为 arr 中的元素值，相同的元素所有的 index 作为 map 的 value；
2. 创建一个队列 queue，然后进行广度优先搜索，同时创建一个 visited = BooleanArray(n)，用来记忆已经访问过的 index，因为已经访问过，说明验证过能否到达终点，无需重复访问；
3. 以 index = 0 为起点，加入 queue，并初始化 step 作为步数记录；
4. 开启循环 BFS，只要 queue 不为空，持续执行：
  4.1 遍历 queue 中的元素
    4.1.1 取出 queue 中的首个元素，如果为 arr 最后的 index，直接返回 step
    4.1.2 添加所有可能的下一步到队列中，首先是遍历相同值的 index 数组（未访问过的），并把这些 index 加入 queue，并标记已访问过
    4.1.3 然后从 map 中移除当前 index，避免后续重复访问
    4.1.4 考虑 index - 1 和 index，加入队列，标记已访问
  4.2 step 计数 + 1
* */