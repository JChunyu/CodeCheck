package algorithms.dfs_bfs.dfs

import java.util.*

class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val rows = image.size
        val columns = image[0].size
        if (sr < 0 || sr >= rows) return image
        if (sc < 0 || sc >= columns) return image
        val current = image[sr][sc]
        if (current != color) {
            dfs(image, sr, sc, current, color)
        }
        return image
    }

    fun dfs(image: Array<IntArray>, x: Int, y: Int, oldColor: Int, color: Int) {
        val rows = image.size
        val columns = image[0].size
        // 坐标点在二维数组范围内
        if (x in 0 until rows && y in 0 until columns) {
            if (image[x][y] == oldColor) {
                image[x][y] = color
                dfs(image, x - 1, y, oldColor, color)
                dfs(image, x + 1, y, oldColor, color)
                dfs(image, x, y - 1, oldColor, color)
                dfs(image, x, y + 1, oldColor, color)
            }
        }
    }

    // 右，下，上，左
    var dx = intArrayOf(1, 0, 0, -1)
    var dy = intArrayOf(0, 1, -1, 0)

    private fun dfs2(image: Array<IntArray>, x: Int, y: Int, color: Int, newColor: Int) {
        if (image[x][y] == color) {
            image[x][y] = newColor
            for (i in 0 until 4) {
                var mx = x + dx[i]
                var my = y + dy[i]
                if (mx >= 0 && mx < image.size && my >= 0 && my < image[0].size) {
                    dfs2(image, mx, my, color, newColor)
                }
            }
        }
    }

    /*
    * BFS 需要借助队列储存广度元素，在根据每个点去查找它的子树
    * */
    private fun bfs(image: Array<IntArray>, x: Int, y: Int, color: Int, newColor: Int) {
        val n = image.size // row
        val m = image[0].size // column
        val queue = LinkedList <IntArray>()

        queue.offer(intArrayOf(x, y));
        image[x][y] = newColor
        while (!queue.isEmpty()) {
            val cell = queue.poll()
            val rx = cell[0]
            val ry = cell[1]
            for (i in 0 until 4) {
                val mx = rx + dx[i]
                val my = ry + dy[i]
                if (mx in 0 until n && my in 0 until m && image[mx][my] == color) {
                    queue.offer(intArrayOf(mx, my))
                    image[mx][my] = newColor
                }
            }
        }
    }
}