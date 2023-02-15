package solution.microsoft.find

/*
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
* */
class FirstUniqChar {
    fun firstUniqChar(s: String): Char {
        val charArray = s.toCharArray()
        val hashMap = HashMap<Char, Int>()
        charArray.forEach {
            if (hashMap.containsKey(it)) {
                val last = hashMap[it] ?: 1
                hashMap[it] = last + 1
            } else {
                hashMap[it] = 1
            }
        }
        charArray.forEach {
            if (hashMap[it] == 1) return it
        }
        return ' '
    }
}