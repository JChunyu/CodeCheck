package 字节150

class IsValidSudokuSolution {
    fun isValidSudoku1(board: Array<CharArray>): Boolean {
        // 确保数组是 9x9
        if (board.size != 9 || board.firstOrNull()?.size != 9) return false
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                if (board[i][j] == '.') continue
                val tmp = board[i][j]
                for (m in j + 1 until board[i].size) {
                    if (tmp == board[i][m]) {
                        return false
                    }
                }
                for (n in i + 1 until board.size) {
                    if (tmp == board[n][j]) {
                        return false
                    }
                }



            }
        }
        return false
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { IntArray(9) }
        val columns = Array(9) { IntArray(9) }
        val subBoxes = Array(3) {
            Array(3) {
                IntArray(9)
            }
        }
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                val current = board[i][j]
                if (current != '.') {
                    // 通过 ascii 值存到数组中到 index 位置上，替代 hashmap
                    var index = current - '0' - 1
                    rows[i][index]++
                    columns[j][index]++
                    subBoxes[i % 3][j % 3][index]++
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subBoxes[i % 3][j % 3][index] > 1) {
                        return false
                    }
                }
            }
        }
        return true
    }

    fun isNumber(s: Char): Boolean = s in '1'..'9'
}