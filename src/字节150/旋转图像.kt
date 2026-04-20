package 字节150

import kotlin.math.max

class Rotate2Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size
        val tempArray = IntArray(n)
        for (i in 0 until n / 2) {
            for (j in 0 until (n + 1) / 2) {
                val curent = matrix[i][j]
                matrix[i][j] = matrix[n - 1 - j][i]
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]
                matrix[j][n - 1 - i] = curent
            }
        }
    }
}
