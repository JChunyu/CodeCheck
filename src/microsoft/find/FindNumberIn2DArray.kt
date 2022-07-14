package microsoft.find

/*
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
class FindNumberIn2DArray {
    fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) return false
        if (matrix[0].isEmpty()) return false
        var row = 0
        var column = 0
        val maxRow = matrix[0].size - 1
        val maxColumn = matrix.size - 1
        if (target > matrix[maxColumn][maxRow] || target < matrix[0][0]) {
            return false
        }
        if (target == matrix[maxColumn][maxRow]) {
            return true
        }
        while (column < matrix.size) {
            while (row < matrix[0].size) {
                if (matrix[column][row] == target) {
                    return true
                }
                row++
            }
            row = 0
            column++
        }
        return false
    }
}