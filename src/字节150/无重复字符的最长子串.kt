package 字节150

import kotlin.math.max

class LengthOfLongestSubstringSolution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length < 2) return s.length
        var low = 0
        var fast = 1
        var hashSet = hashSetOf<Char>()
        hashSet.add(s[0])
        var res = 1

        while (fast < s.length) {
            if (hashSet.contains(s[fast])) {
                hashSet.remove(s[low])
                low++
            } else {
                hashSet.add(s[fast])
                res = max(res, fast - low + 1)
                fast++
            }
        }
        return res
    }
}

fun main() {
    println(LengthOfLongestSubstringSolution().lengthOfLongestSubstring("bbbbbb"))
}