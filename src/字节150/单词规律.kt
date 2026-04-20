package 字节150

class WordPatternSolution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val words = s.split(' ')
        if (words.size != pattern.length) return false
        val length = pattern.length
        val pHashMap = hashMapOf<Char, String>()
        val wHashMap = hashMapOf<String, Char>()
        for (i in 0 until length) {
            var p = pattern[i]
            var w = words[i]
            if (pHashMap.containsKey(p) && pHashMap[p] != w) return false
            if (wHashMap.containsKey(w) && wHashMap[w] != p) return false
            pHashMap[p] = w
            wHashMap[w] = p
        }
        return true
    }
}