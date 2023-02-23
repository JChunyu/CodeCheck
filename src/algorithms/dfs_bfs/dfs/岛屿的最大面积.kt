package algorithms.dfs_bfs.dfs

import java.util.*


class MaxAreaOfIsland {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var max = 0
        val row = grid.size
        val col = grid[0].size
        for (i in 0 until row) {
            for (j in 0 until col) {
                max = Math.max(max, dfs(grid, i, j))
            }
        }
        return max
    }

    private fun dfs(grid: Array<IntArray>, x: Int, y: Int): Int {
        if (x in grid.indices && y in 0 until grid[0].size) {
            if (grid[x][y] == 1) {
                grid[x][y] = 0
                var ans = 1
                ans += dfs(grid, x + 1, y)
                ans += dfs(grid, x - 1, y)
                ans += dfs(grid, x, y + 1)
                ans += dfs(grid, x, y - 1)
                return ans
            }
        }
        return 0
    }

    fun maxAreaOfIsland2(grid: Array<IntArray>): Int {
        var ans = 0
        for (i in grid.indices) {
            for (j in 0 until grid[0].size) {
                var cur = 0
                val stacki: Deque<Int> = LinkedList()
                val stackj: Deque<Int> = LinkedList()
                stacki.push(i)
                stackj.push(j)
                while (!stacki.isEmpty()) {
                    val cur_i = stacki.pop()
                    val cur_j = stackj.pop()
                    if (cur_i < 0 || cur_j < 0 || cur_i == grid.size || cur_j == grid[0].size || grid[cur_i][cur_j] != 1) {
                        continue
                    }
                    ++cur
                    grid[cur_i][cur_j] = 0
                    val di = intArrayOf(0, 0, 1, -1)
                    val dj = intArrayOf(1, -1, 0, 0)
                    for (index in 0..3) {
                        val next_i = cur_i + di[index]
                        val next_j = cur_j + dj[index]
                        stacki.push(next_i)
                        stackj.push(next_j)
                    }
                }
                ans = Math.max(ans, cur)
            }
        }
        return ans
    }
}