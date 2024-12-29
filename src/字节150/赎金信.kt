package 字节150

class CanConstructSolution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val hashMap = hashMapOf<Char, Int>()
        magazine.forEach {
            if (hashMap.containsKey(it)) {
                val count = hashMap[it] ?: 0
                hashMap[it] = count + 1
            } else {
                hashMap[it] = 1
            }
        }
        ransomNote.forEach {
            if (hashMap[it] == null || hashMap[it] == 0) {
                return false
            } else {
                hashMap[it] = hashMap[it]!! - 1
            }
        }
        return true
    }
}