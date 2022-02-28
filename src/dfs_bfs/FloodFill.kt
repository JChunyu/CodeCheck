package dfs_bfs

import java.util.*

class FloodFill {
    // 右，下，上，左
    var dx = intArrayOf(1, 0, 0, -1)
    var dy = intArrayOf(0, 1, -1, 0)

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val currColor = image[sr][sc]
        if (currColor != newColor) {
//            dfs(image, sr, sc, currColor, newColor);
            bfs(image, sr, sc, currColor, newColor)
        }
        return image
    }

    // 深度优先
    private fun dfs(image: Array<IntArray>, x: Int, y: Int, color: Int, newColor: Int) {
        if (x >= 0 && x < image.size && y >= 0 && y < image[0].size) {
            if (image[x][y] == color) {
                image[x][y] = newColor
                dfs(image, x + 1, y, color, newColor)
                dfs(image, x ,y + 1, color, newColor)
                dfs(image, x - 1, y, color, newColor)
                dfs(image, x, y - 1, color, newColor)
            }
        }
    }

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
    // 广度优先
}