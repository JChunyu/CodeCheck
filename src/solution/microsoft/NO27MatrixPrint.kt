package solution.microsoft

class NO27MatrixPrint {

    // 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
    fun spiralOrder(matrix: Array<IntArray>): IntArray {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return intArrayOf()
        }
        var i = 0
        var j = 0
        // 行列最大值
        val row = matrix.size
        val column = matrix[0].size
        // 数组总数量
        var size = row * column
        val res = ArrayList<Int>()
        val listIterator = res.listIterator()


        // 四个方向
        val UP = 1
        val DOWN = 2
        val LEFT = 3
        val RIGHT = 4
        var direction = RIGHT
        // 四个方向的边界
        var left = 0
        var right = column - 1
        var top = 0
        var bottom = row- 1

        while (size >  0) {
            res.add(matrix[i][j])
            when(direction) {
                RIGHT -> {
                    if (j >= right) {
                        // 变向
                        direction = DOWN
                        i++
                        top++
                    } else {
                        j++
                    }
                }
                DOWN -> {
                    if (i >= bottom) {
                        direction = LEFT
                        j--
                        right--
                    } else {
                        i++
                    }
                }
                LEFT -> {
                    if (j <= left) {
                        direction = UP
                        i--
                        bottom--
                    } else {
                        j--
                    }
                }
                UP -> {
                    if (i <= top) {
                        direction = RIGHT
                        j++
                        left++
                    } else {
                        i--
                    }
                }
            }
            size--
        }
        return res.toIntArray()
    }
}


fun main() {
    val matrix: Array<IntArray> = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )

    val array = NO27MatrixPrint().spiralOrder(matrix)
    array.forEach {
        print(it)
    }
}
/*
[1,2,3],
[4,5,6],
[7,8,9]]
* */