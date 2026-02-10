package leetcode

fun transpose(matrix: Array<IntArray>): Array<IntArray> {
    val rowSize = matrix[0].size
    val lineSize = matrix.size
    val newMatrix = Array(rowSize) { IntArray(lineSize) }

    for (i in 0 until lineSize) {
        for (j in 0 until rowSize) {
            newMatrix[j][i] = matrix[i][j]
        }
    }
    return newMatrix
}