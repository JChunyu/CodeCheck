package algorithms.dfs_bfs.bfs

import java.util.*


/*

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
mat 中至少有一个 0

* */
class UpdateMatrix {
    var dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        return bfs(mat)
    }

    /*
    * 广度优先搜索可以找到从起点到其余所有点的最短距离
    * */
    fun bfs(mat: Array<IntArray>): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size
        val dist = Array(m) { IntArray(n) }
        val seen = Array(m) { BooleanArray(n) }

        val queue: Queue<IntArray> = LinkedList()

        // 添加所有的 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (mat[i][j] == 0) {
                    queue.offer(intArrayOf(i, j))
                    seen[i][j] = true
                }
            }
        }
        while (!queue.isEmpty()) {
            val cell = queue.poll()
            val x = cell[0]
            val y = cell[1]
            dirs.forEach {
                val dx = x + it[0]
                val dy = y + it[1]
                if (dx in 0 until m && dy in 0 until n && !seen[dx][dy]) {
                    dist[dx][dy] = dist[x][y] + 1
                    queue.offer(intArrayOf(dx, dy))
                    seen[dx][dy] = true
                }
            }
        }
        return dist
    }


    fun dynamic(mat: Array<IntArray>): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size
        val dist = Array(m) { IntArray(n) }

        for (i in 0 until m) {
            for (j in 0 until n) {

            }
        }
        return arrayOf(intArrayOf(0, 0))
    }
}