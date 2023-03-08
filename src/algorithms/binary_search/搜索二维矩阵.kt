package algorithms.binary_search

class SearchMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) return false
        var row = 0
        for (i in matrix.indices) {
            if (target == matrix[i][0]) {
                return true
            } else if (target < matrix[i][0]) {
                // 第一个小于
                row = i - 1
                break
            } else {
                row = i
            }
        }
        if (row < 0) return false
        var left = 0
        var right = matrix[0].size - 1
        val array = matrix[row]
        while (left <= right) {
            val mid = (right - left) / 2 + left
            when {
                target == array[mid] -> {
                    return true
                }
                target < array[mid] -> {
                    right = mid - 1
                }
                else -> {
                    left = mid + 1
                }
            }
        }
        return false
    }
}

fun main() {
    val r = SearchMatrix().searchMatrix(arrayOf(
        intArrayOf(1,3,5,7),
        intArrayOf(10,11,16,20),
        intArrayOf(23,30,34,60)
    ), 30)

    print(r)
}