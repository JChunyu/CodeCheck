package solution.microsoft

import java.util.LinkedList

class NO13movingCount {
    /*
    * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
    * 一个机器人从坐标 [0, 0] 的格子开始移动，
    * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
    * 也不能进入行坐标和列坐标的数位之和大于k的格子。
    * 例如，当k为18时，机器人能够进入方格 [35, 37] ，
    * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
    * 请问该机器人能够到达多少个格子？
    * */

    /*
    * 知识点：二维数组遍历问题，一般两种解决思路，广度遍历和深度遍历，去重用一个新的二维数组左已查看标记。
    * 广度优先一般使用队列
    * 深度优先一般使用递归
    * */

    // 第一种，广度遍历，只处理向右向下
    fun movingCount(m: Int, n: Int, k: Int): Int {
        val queue = LinkedList<IntArray>()
        var count = 0
        val visited = Array(m) {
            Array(n) {
                false
            }
        }
        queue.offer(intArrayOf(0, 0))
        visited[0][0] = true
        count = 1
        while (queue.isNotEmpty()) {
            val temp = queue.poll()
            val x = temp[0]
            val y = temp[1]
            // check right
            if (y in 0 until (n - 1) && sumDigtal(x) + sumDigtal(y + 1) <= k && !visited[x][y + 1]) {
                queue.offer(intArrayOf(x, y + 1))
                visited[x][y + 1] = true
                count++
            }
            // check down
            if (x in 0 until (m - 1) && sumDigtal(x + 1) + sumDigtal(y) <= k && !visited[x + 1][y]) {
                queue.offer(intArrayOf(x + 1, y))
                visited[x + 1][y] = true
                count++
            }
        }
        return count
    }

    fun sumDigtal(x: Int): Int {
        var tempX = x
        var sumX = 0
        while (tempX > 0) {
            sumX += tempX % 10
            tempX /= 10
        }
        return sumX
    }

    // 递归解决，需要一个二维数组去重
    fun movingCount2(m: Int, n: Int, k: Int): Int {
        val seed = Array(m) {
            Array(n) {
                false
            }
        }
        return check(0, 0, m, n, k, seed)
    }

    private fun check(x: Int, y: Int, m: Int, n: Int, k: Int, array: Array<Array<Boolean>>): Int {
        if (x < 0 || x >= m || y < 0 || y >= n || array[x][y]) {
            return 0
        }
        array[x][y] = true
        var tempX = x
        var sumX = 0
        while (tempX > 0) {
            sumX += tempX % 10
            tempX /= 10
        }
        var tempY = y
        var sumY = 0
        while (tempY > 0) {
            sumY += tempY % 10
            tempY /= 10
        }
        return if (sumX + sumY <= k) {
            1 + check(x + 1, y, m, n, k, array) + check(x, y + 1, m, n, k, array)
        } else {
            0
        }
    }

}

fun main() {
    val so = NO13movingCount()
    var i = so.movingCount(38, 15, 9)
    var j = so.movingCount2(38, 15, 9)
    println(i)
    println()
}

