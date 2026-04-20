package 字节150

class IsPalindromeSolution {
    fun isPalindrome(s: String): Boolean {
        val lowercase = s.lowercase()
        var start = 0
        var end = s.length - 1
        while (start <= end) {
            if (!lowercase[start].isWord()) {
                start++
            } else if (!lowercase[end].isWord()) {
                end--
            } else if (lowercase[start].isWord() && lowercase[end].isWord()) {
                if (lowercase[start] == lowercase[end]) {
                    start++
                    end--
                } else {
                    return false
                }
            }
        }
        return true
    }

    private fun Char.isWord(): Boolean {
        return this in 'a'..'z' || this in '0'..'9'
    }
}

fun main() {
    val ans = IsPalindromeSolution().isPalindrome("0P")
    println(ans)
}
