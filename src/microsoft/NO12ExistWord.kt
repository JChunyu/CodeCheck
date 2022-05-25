package microsoft

class NO12ExistWord {
    /*
    * 假设最后一次存在， 向左或向上
    *
    * */
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val row = board.size
        val column = board[0].size
        for (i in 0 until row) {
            for (j in 0 until column) {
                if (check(board, word, i, j, 0)) {
                    return true
                }
            }
        }
        return false
    }
    fun check(board: Array<CharArray>, word: String, i: Int, j: Int, k: Int): Boolean {
        if (i < 0 || i >= board.size || j < 0 || j >= board[0].size || board[i][j] != word[k]) return false
        if (k == word.length - 1) return true
        return check(board, word, i - 1, j, k + 1) || check(board, word, i, j - 1, k + 1)
                || check(board, word, i + 1, j, k + 1) || check(board, word, i, j + 1, k + 1)
    }
}
