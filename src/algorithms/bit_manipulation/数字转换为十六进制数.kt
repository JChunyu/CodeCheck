package algorithms.bit_manipulation

import java.lang.StringBuilder
/*
* 一位十六进制数对应四位二进制数，因此 32 位有符号整数的十六进制数有 8 位。
* 假设二进制数的 8 组从低位到高位依次是第 0 组到第 7 组，则对于第 i 组，可以通过 (nums >> (4 x i)) & 0xf 得到该组的值，其取值范围是 0 到 15（即十六进制的 f）。
* */
fun toHex(num: Int): String {
    if (num == 0) return "0"
    val number = arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')
    val ans = StringBuilder()

    for (i in 7 downTo 0) {
        val digit = (num shr (4 * i)) and 0xf
        if (ans.isNotEmpty() || digit > 0) {
            val char = number[digit]
            ans.append(char)
        }
    }
    return ans.toString()
}

fun main() {
    println(toHex(-15))
}