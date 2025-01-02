package leetcode

import kotlin.math.max

class AddBinarySolution {
    fun addBinary(a: String, b: String): String {
        val length = max(a.length, b.length)
        val ans = CharArray(length + 1) { '0' }
        val todo = if (a.length <= b.length) {
            for (i in 1 until ans.size) {
                ans[i] = b[i - 1]
            }
            a
        } else {
            for (i in 1 until ans.size) {
                ans[i] = a[i - 1]
            }
            b
        }
        var enter = 0
        var reverseIndex = todo.length - 1
        var ansIndex = ans.size - 1

        while (ansIndex >= 0) {
            val ansChar = ans[ansIndex]
            var unitSum = enter
            enter = 0

            if (reverseIndex >= 0) {
                val todoChar = todo[reverseIndex]
                if (todoChar == '1') {
                    unitSum += 1
                }
            }

            if (ansChar == '1') {
                unitSum += 1
            }

            when (unitSum) {
                3 -> {
                    unitSum = 1
                    enter = 1
                }
                2 -> {
                    unitSum = 0
                    enter = 1
                }
            }
            ans[ansIndex] = if (unitSum == 1) '1' else '0'
            ansIndex--
            reverseIndex--
        }
        return if (ans[0] == '0') {
            ans.concatToString().substring(1, ans.size)
        } else {
            ans.concatToString()
        }
    }
}

fun main() {
    val ans = AddBinarySolution().addBinary("1100", "10")
    println(ans)
}