package algorithms.sliding_window

class LengthOfLongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        val hashSet = HashSet<Char>()
        var i = 0
        var j = 0
        var max = 0

        while (i < s.length && j < s.length) {
            val c = s[j]
            val p = s[i]
            if (hashSet.contains(c)) {
                hashSet.remove(p)
                i++
            } else {
                hashSet.add(c)
                j++
                max = Math.max(max, j - i)
            }
        }
        return max
    }
}