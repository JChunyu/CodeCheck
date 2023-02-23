package algorithms.sliding_window

class CheckInclusion {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val n = s1.length
        var i = 0
        var j = n - 1
        val map = HashMap<Char, Int>()
        for (c in s1) {
            map[c] = (map[c] ?: 0) + 1
        }
        val hashMap = HashMap<Char, Int>()

        for (x in s1.indices) {
            val char = s2[x]
            hashMap[char] = (hashMap[char] ?: 0) + 1
        }

        while (j < s2.length) {
            if (hashMap == map) {
                return true
            } else {
                val prev = hashMap[s2[i]] ?: 0
                if (prev == 0) {
                    hashMap.remove(s2[i])
                } else {
                    val new = prev - 1
                    if (new == 0) {
                        hashMap.remove(s2[i])
                    } else {
                        hashMap[s2[i]] = new
                    }
                }
                i++
                j++
                if (j < s2.length) {
                    hashMap[s2[j]] = (hashMap[s2[j]] ?: 0) + 1
                }
            }
        }
        return false
    }

    fun checkInclusion2(s1: String, s2: String): Boolean {
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

fun main() {
    val i = CheckInclusion().checkInclusion("ab", "eidbaooo")
    println(i)
}