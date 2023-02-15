package todo

import java.lang.StringBuilder
import java.util.*

/*
* 1 <= num <= 3999
* */

class RomanNumber {

    private val singles = hashMapOf<Int, String>().apply {
        put(1, "I")
        put(4, "IV")
        put(5, "V")
        put(9, "IX")
    }

    private val tens = hashMapOf<Int, String>().apply {
        put(1, "X")
        put(4, "XL")
        put(5, "L")
        put(9, "XC")
    }

    private val hundreds = hashMapOf<Int, String>().apply {
        put(1, "C")
        put(4, "CD")
        put(5, "D")
        put(9, "CM")
    }

    private val thousands = hashMapOf<Int, String>().apply {
        put(1, "M")
    }

    fun intToRoman(num: Int): String {

        val stack = LinkedList<String>()
        var number = num
        // 边界条件
        if (number >= 4000 || number <= 0) {
            return "null"
        }
        var digital = 0 // 用来记录位数
        while (number > 0) {
            // 处理位数变换
            val digitMap = when(digital) {
                0 -> singles
                1 -> tens
                2 -> hundreds
                3 -> thousands
                else -> emptyMap()
            }
            val a = number / power(digital)
            var current = a % 10
            when {
                current == 9 -> {
                    stack.push(digitMap[9])
                    number -= 9 * power(digital)
                }
                current >= 5 -> {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append(digitMap[5])
                    var temp = current - 5
                    while (temp > 0) {
                        stringBuilder.append(digitMap[1])
                        temp--
                    }
                    stack.push(stringBuilder.toString())
                    number -= current * power(digital)
                }
                current == 4 -> {
                    stack.push(digitMap[4])
                    number -= 4 * power(digital)
                }
                else -> {
                    val stringBuilder = StringBuilder()
                    number -= current * power(digital)
                    while (current > 0) {
                        stringBuilder.append(digitMap[1])
                        current--
                    }
                    stack.push(stringBuilder.toString())
                }
            }
            digital++
        }
        val stringBuilder = StringBuilder()
        while (stack.isNotEmpty()) {
            stringBuilder.append(stack.pop())
        }
        return stringBuilder.toString()
    }

    private fun power(num: Int): Int {
        var number = num
        var start = 1
        while (number > 0) {
            start *= 10
            number--
        }
        return start
    }
}

fun main() {
    val roman = RomanNumber()
    println(roman.intToRoman(149))

}