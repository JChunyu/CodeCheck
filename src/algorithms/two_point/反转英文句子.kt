package algorithms.two_point

import java.lang.StringBuilder

/*
* 反转英文句子
* 思路 双指针
* 1 检查字符串中 ' ' 为分界
* 2 right指针先走，走到第一个 ' ' ， left 仍在初始位置。 然后反转 left - right 这段内容
* 3 left = right，right 继续走到下一个空格
* 4 重复 2 3， 直到 right = s.size
* */
class ReverseWords {
    fun reverseWords(s: String): String {
        val result = StringBuilder()
        var left = 0
        var right = 0

        while (right < s.length) {
            val cur = s[right]
            if (right == s.length - 1) {
                if (s[right] == ' ') {
                    // 反转left - right 这段内容
                    val word = s.substring(left, right)
                    result.append(word.reversed())
                    left = ++right
                } else {
                    // 反转left - right 这段内容
                    val word = s.substring(left, right + 1)
                    result.append(word.reversed())
                    break
                }
            }
            if (cur == ' ') {
                // 反转left - right 这段内容
                val word = s.substring(left, right)
                result.append(word.reversed())
                result.append(' ')
                left = ++right
            } else {
                right++
            }
        }
        return result.toString()
    }
}

fun main() {
    println("\"" + ReverseWords().reverseWords("hello ndna ") + "\"" )
}

/*
var charArray = s.toCharArray()
        var reverseIndex = charArray.size - 1
        var result = CharArray(charArray.size + 1)
        result[0] = ' '
        var resultIndex = 1
        // 整个字符数组反转
        while (reverseIndex >= 0) {
            result[resultIndex] = charArray[reverseIndex]
            reverseIndex--
            resultIndex++
        }
        // 从后向前，以 ' ' 为分割单词，添加到新数组中
        var rightIndex = result.size - 1
        var lastWordRight = result.size
        val realResult = CharArray(result.size)
        var realRIndex = 0
        while (rightIndex >= 0) {
            if (result[rightIndex] == ' ') {
                for (i in rightIndex until lastWordRight) {
                    realResult[realRIndex] = result[i]
                    realRIndex++
                }
                lastWordRight = rightIndex
            }
            rightIndex--
        }
        val stingBuilder = StringBuilder()
        for (i in 1 until realResult.size) {
            stingBuilder.append(realResult[i])
        }
        return stingBuilder.toString()
* */