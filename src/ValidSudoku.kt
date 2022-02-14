
/*
* 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 
注意：
一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
空白格用 '.' 表示。
* */
class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val hashMap = HashMap<Char, Boolean>()
        hashMap['1'] = true
        hashMap['2'] = true
        hashMap['3'] = true
        hashMap['4'] = true
        hashMap['5'] = true
        hashMap['6'] = true
        hashMap['7'] = true
        hashMap['8'] = true
        hashMap['9'] = true

        val rowCheckArray = ArrayList<HashMap<Char, Boolean>>()
        val columnCheckArray = ArrayList<HashMap<Char, Boolean>>()
        val blockCheckArray = ArrayList<HashMap<Char, Boolean>>()

        // 给方块用的，检查归属于哪个区块
        val idArray = arrayListOf(
            intArrayOf(0, 1, 2),
            intArrayOf(3, 4, 5),
            intArrayOf(6, 7, 8)
        )

        // 用于检查的行、列、块数组
        for (i in 0..8) {
            rowCheckArray.add(hashMap)
            columnCheckArray.add(hashMap)
            blockCheckArray.add(hashMap)
        }

        for (i in 0 until 9) {
            for (j in 0 until 9) {
                val char = board[i][j]
                if (char != '.') {
                    // 行检查
                    if (rowCheckArray[i].containsKey(char)) {
                        rowCheckArray[i].remove(char)
                    } else {
                        return false
                    }
                    // 列检查
                    if (!columnCheckArray[j].containsKey(char)) {
                        columnCheckArray[j].remove(char)
                    } else {
                        return false
                    }
                    // 块检查
                    if (!blockCheckArray[idArray[i / 3][j / 3]].containsKey(char)) {
                        blockCheckArray[idArray[i / 3][j / 3]].remove(char)
                    } else {
                        return false
                    }
                }
            }
        }
        return true
    }
}