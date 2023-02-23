package algorithms.two_point

import java.lang.StringBuilder

/*
 * @lc app=leetcode.cn id=345 lang=kotlin
 *
 * [345] 反转字符串中的元音字母
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 * */

class ReverseVowels {
    fun reverseVowels(s: String): String {
        val targets = hashSetOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        var left = 0
        var right = s.length - 1
        val c = s.toCharArray()
        while (left < right) {
            if (targets.contains(c[left])) {
                if (targets.contains(c[right])) {
                    val temp = c[right]
                    c[right] = c[left]
                    c[left] = temp
                    left++
                }
                right--
                continue
            } else {
                left++
            }
        }
        val stringBuilder = StringBuilder()
        c.forEach {
            stringBuilder.append(it)
        }
        return stringBuilder.toString()
    }
}

fun main() {
    val n = ReverseVowels().reverseVowels("aA")
    println(n)
}