package microsoft.dynamicprogramming

class LengthOfLongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        val hashSet = HashSet<Char>()
        var res = 0
        var left = 0
        while (left < s.length) {
            hashSet.clear()
            var right = left
            var temp = 0
            while (right < s.length && !hashSet.contains(s[right])) {
                hashSet.add(s[right])
                temp++
                res = Math.max(res, temp)
                right++
            }
            left++
        }
        return res
    }
}