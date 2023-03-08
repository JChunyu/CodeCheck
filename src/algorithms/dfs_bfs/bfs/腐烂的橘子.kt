package algorithms.dfs_bfs.bfs

import java.util.*
import kotlin.collections.ArrayList

class OrangesRotting {

    var dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

    fun orangesRotting(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) return -1
        val m = grid.size
        val n = grid[0].size
        val seen = Array(m) { BooleanArray(n) }
        var result = 0
        val queue: Queue<ArrayList<IntArray>> = LinkedList()
        // 添加所有的 0
        val zeroArray = arrayListOf<IntArray>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 2) {
                    zeroArray.add(intArrayOf(i, j))
                    seen[i][j] = true
                }
                if (grid[i][j] == 0) {
                    seen[i][j] = true
                }
            }
        }
        queue.offer(zeroArray)

        while (!queue.isEmpty()) {
            val list = queue.poll()
            val array = arrayListOf<IntArray>()
            list.forEach { cur ->
                val x = cur[0]
                val y = cur[1]
                dirs.forEach {
                    val dx = x + it[0]
                    val dy = y + it[1]
                    if (dx in 0 until m && dy in 0 until n && !seen[dx][dy]) {
                        if (grid[dx][dy] == 1) {
                            grid[dx][dy] = 2
                            array.add(intArrayOf(dx, dy))
                            seen[dx][dy] = true
                        }
                    }
                }
            }
            if (array.isNotEmpty()) {
                queue.offer(array)
                result++
            }
        }

        seen.forEach {
            if (it.contains(false)) return -1
        }
        return result
    }
}

fun main() {
    val n = OrangesRotting().orangesRotting(
        arrayOf(
            intArrayOf(2,0,0)
        )
    )
    println(n)
}