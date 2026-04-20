package 字节150

class ZConvertSolution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        val matrix = Array(numRows) { CharArray(s.length) { ' '} }
        var x = 0
        var y = 0
        var sequence = false
        for (i in s.indices) {
            if (x == numRows - 1 || x == 0) {
                sequence = !sequence
            }
            if (sequence) {
                matrix[x++][y] = s[i]
            } else {
                matrix[x--][y++] = s[i]
            }
        }
        val stringBuilder = java.lang.StringBuilder()
        matrix.forEach {
            it.forEach {
                if (it != ' ') {
                    stringBuilder.append(it)
                }
            }
        }
        return stringBuilder.toString()
    }
}

fun main() {
    val ans = ZConvertSolution().convert("AB", 1)
    println(ans)
}
