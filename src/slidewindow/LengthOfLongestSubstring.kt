package slidewindow

/*
* 滑动窗口，需要双指针进行
* */
class LengthOfLongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        val hashSet = HashSet<Char>()
        val charArray = s.toCharArray()

        var i = 0
        var j = 0
        var max = 0
        while (i < charArray.size && j < charArray.size) {
            if (hashSet.contains(charArray[j])) {
                hashSet.remove(charArray[i])
                i++
            } else {
                hashSet.add(charArray[j])
                j++
                max = Math.max(max, j - i)
            }
        }
        return max
    }
}

// abcabcdbb