package algorithms.bit_manipulation

// 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
class CountBits {
    fun countBits(n: Int): IntArray {
        val length = n + 1
        val array = IntArray(length)
        for (i in 0 until length) {
            var count = 0
            var n = i
            while (n != 0) {
                // 每次去掉最后一位 1，将最后一位的 1 变成 0
                n = n and (n - 1)
                count++
            }
            array[i] = count
        }
        return array
    }
}

fun main() {
    val countBits = CountBits().countBits(9)
    countBits.forEach {
        println(it)
    }
}