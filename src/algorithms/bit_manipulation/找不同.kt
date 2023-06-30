package algorithms.bit_manipulation

class FindTheDifference {
    fun findTheDifference(s: String, t: String): Char {
        var sum = 0
        t.forEach {
            sum = sum xor it.code
        }
        s.forEach {
            sum = sum xor it.code
        }
        return sum.toChar()
    }
}

// 异或 xor 特性
// 1. 任何数与 0 做异或运算，结果都是原数字
// 2. 任何数与自身做异或运算，结果是 0
// 3. 异或运算满足交换律和结合律

fun main() {
    val r = FindTheDifference().findTheDifference("abcde", "abcdef")
    println(r)
}