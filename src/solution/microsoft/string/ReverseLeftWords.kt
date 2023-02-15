package solution.microsoft.string

class ReverseLeftWords {
    fun reverseLeftWords(s: String, n: Int): String {
        val strinBuilder = StringBuilder()
        var point = n
        while (point < s.length) {
            strinBuilder.append(s[point++])
        }
        for (i in 0 until n) {
            strinBuilder.append(s[i])
        }
        return strinBuilder.toString()
    }
}

fun main() {
    val r = ReverseLeftWords().reverseLeftWords("abcdefg", 2)
    println(r)
}