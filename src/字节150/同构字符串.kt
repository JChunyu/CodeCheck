package 字节150

class IsIsomorphicSolution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val shashMap = hashMapOf<Char, Char>()
        val thashMap = hashMapOf<Char, Char>()

        for (i in s.indices) {
            if (shashMap.containsKey(s[i]) && shashMap.get(s[i]) != t[i] || thashMap.containsKey(t[i]) && thashMap.get(t[i]) != s[i]) {
                return false
            }
            shashMap.put(s[i], t[i])
            thashMap.put(t[i], s[i])
        }
        return true
    }
}

fun main() {
    val ans = IsIsomorphicSolution().isIsomorphic("foo", "bar")
    println(ans)
}