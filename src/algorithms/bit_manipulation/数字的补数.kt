package algorithms.bit_manipulation

class FindComplement {
    fun findComplement(num: Int): Int {
        var i = 1
        while (i < num) {
            // 比当前 num 高一位二进制，例如 num = 5（101）， i 右移后为 （1000）
            i = i shl 1
            // 因为上一步右移后二进制位比 num 多一位，所以对其进行异或 1 操作
            i = i xor 1
        }
        return num xor i
    }
}

fun main() {
    println(FindComplement().findComplement(99))
}