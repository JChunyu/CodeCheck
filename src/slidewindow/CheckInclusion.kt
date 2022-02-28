package slidewindow
/*
*
*给你两个字s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
换句话说，s1 的排列之一是 s2 的 子串 。
* */
class CheckInclusion {
    fun checkInclusion(s1: String, s2: String): Boolean {
        var i = 0
        var j = 0
        val map = HashMap<Char, Int>()
        val s1Array = s1.toCharArray()
        val s2Array = s2.toCharArray()

        // 全部加入到map中
        s1Array.forEach {
            if (map.containsKey(it)) {
                map[it] = (map[it] ?: 0) + 1
            } else {
                map[it] = 1
            }
        }
        // 全部存到temp中
        val tempMap = HashMap<Char, Int>().apply {
            putAll(map)
        }
        while (i < s2.length && (j - i) < s1.length && j < s2.length) {
            if (tempMap.containsKey(s2Array[j])) {
                tempMap[s2Array[j]] = (tempMap[s2Array[j]] ?: 0) - 1
                // 删除出现过的数字
                if ((tempMap[s2Array[j]] ?: 0) <= 0) {
                    tempMap.remove(s2Array[j])
                }
                if (tempMap.isEmpty()) {
                    return true
                }
                j++
            } else {
                i++
                j = i
                tempMap.clear()
                tempMap.putAll(map)
            }
        }
        return false
    }
}