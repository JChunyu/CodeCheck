package algorithms.bit_manipulation

class HasAlternatingBits {
    fun hasAlternatingBits(n: Int): Boolean {
        var a = n
        var last = a and 1 // 最后一位是 1 还是 0
        while (a > 0) {
            a = a shr 1 // 左移乘以2，右移除以2
            val newLast = a and 1 // 新的最后一位
            if (last == newLast) { // 连续的两位不相等
                return false
            }
            last = newLast
        }
        return true
    }
}

//
fun main() {
    val ans = HasAlternatingBits().hasAlternatingBits(11)
    println(ans)
}