package microsoft

class NO58LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        val a = s.reversed()
        var i = 0
        var j = 0
        // 过滤掉开头的空格
        while (i < s.length && a[i] == ' ') {
            i++
        }
        j = i
        while (j < s.length && a[j] != ' ') {
            j++
        }
        return j - i
    }
}

fun main() {
    NO58LengthOfLastWord().lengthOfLastWord("a")
}