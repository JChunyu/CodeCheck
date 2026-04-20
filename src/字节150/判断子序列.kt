package 字节150

class IsSubsequenceSolution {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isBlank()) return true
        if (t.isBlank()) return false
        for (i in t.indices) {
            // 匹配到第一个字符存在，开始检查后续内容
            if (s[0] == t[i]) {
                var tIndex = i
                var sIndex = 0
                while (sIndex < s.length && tIndex < t.length) {
                    if (s[sIndex] == t[tIndex]) {
                        sIndex++
                        tIndex++
                    } else {
                        tIndex++
                    }
                }
                if (sIndex == s.length) {
                    return true
                } else {
                    continue
                }
            }
        }
        return false
    }

    fun isSubsequence2(s: String, t: String): Boolean {
        if (s.length < 2) return t.contains(s)
        var i = 0
        while (i < t.length) {
            if (s[0] == t[i]) {
                var sIndex = 0
                var tIndex = i
                while (sIndex < s.length && tIndex < t.length) {
                    if (s[sIndex] == t[tIndex]) {
                        sIndex++
                        tIndex++
                    } else {
                        break
                    }
                }
                if (sIndex == s.length) {
                    return true
                } else {
                    i++
                }
            } else {
                i++
            }
        }
        return false
    }
}

fun main() {
    var ans = IsSubsequenceSolution().isSubsequence("axc", "ahbgdc")
    println(ans)
}