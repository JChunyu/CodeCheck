package algorithms

class StringProj {

    /*
    * 13. 罗马数字转整数
    * */
    fun romanToInt(s: String): Int {
        val hashMap: HashMap<Char, Int> = hashMapOf()
        hashMap.put('I', 1)
        hashMap.put('V', 5)
        hashMap.put('X', 10)
        hashMap.put('L', 50)
        hashMap.put('C', 100)
        hashMap.put('D', 500)
        hashMap.put('M', 1000)

        
    }

    /*
    * 28. 找出字符串中第一个匹配项的下标
    * */
    fun strStr(haystack: String, needle: String): Int {
        if (haystack.isEmpty()) return -1
        if (needle.isEmpty()) return 0

        var ans = -1

        haystack.forEachIndexed { index, c ->
            if (c == needle[0]) {
                ans = index
                for (i in needle.indices) {
                    if (index + i >= haystack.length) {
                        ans = -1
                        break
                    }
                    if (haystack[index + i] == needle[i]) {
                        continue
                    } else {
                        ans = -1
                        break
                    }
                }
                if (ans != -1) return ans
            }
        }
        return ans
    }
}