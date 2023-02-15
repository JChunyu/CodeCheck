package solution.todo

import java.util.*

/*
给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。

输入：s = "aa", p = "a"
输出：false
解释："a" 无法匹配 "aa" 整个字符串。

输入：s = "aa", p = "a*"
输出：true
解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。

输入：s = "ab", p = ".*"
输出：true
解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。

tips:
1 <= s.length <= 20
1 <= p.length <= 30
s 只包含从 a-z 的小写字母。
p 只包含从 a-z 的小写字母，以及字符 . 和 *。
保证每次出现字符 * 时，前面都匹配到有效的字符
* */
class MatchExpression {
    fun isMatch(s: String, p: String): Boolean {
        val CHAR = arrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
        val MATCH_CHAR = arrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '.', '*')

        // 1. 过滤不合法字符
        s.forEach {
            if (!CHAR.contains(it)) {
                return false
            }
        }
        p.forEach {
            if (!MATCH_CHAR.contains(it)) {
                return false
            }
        }

        // 2. 处理 * 尾部字符
        val queue = LinkedList(s.toCharArray().toList())
        val expressionQueue = LinkedList(p.toCharArray().toList())

        var prev: Char? = null
        var starTempQueue = LinkedList<Char>()

        while (expressionQueue.isNotEmpty()) {
            val current = expressionQueue.pop()

            when(current) {
                '.' -> {
                    if (queue.isNotEmpty()) {
                        queue.pop()
                    }
                }
                '*' -> {
                    if (prev != starTempQueue.peek()) {
                        starTempQueue.clear()
                    }
                    if (prev == null) {
                        return false
                    } else if (prev == '.') {
                        prev = queue.peek()
                    }
                    while (queue.peek() == prev) {
                        starTempQueue.push(queue.pop())
                    }
                }
                else -> {
                    if (queue.isNotEmpty() && current == queue.peek()) {
                        queue.pop()
                    } else {
                        if (starTempQueue.isNotEmpty() && current == starTempQueue.peek()) {
                            starTempQueue.pop()
                        } else {
                            return false
                        }
                    }
                }
            }
            prev = current
        }
        return queue.isEmpty()
    }

    fun isMatch2(s: String, p: String): Boolean {
        val m = s.length
        val n = p.length
        val f = Array(m + 1) { BooleanArray(n + 1) }
        f[0][0] = true
        for (i in 0..m) {
            for (j in 1..n) {
                if (p[j - 1] == '*') {
                    f[i][j] = f[i][j - 2]
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j]
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1]
                    }
                }
            }
        }
        return f[m][n]
    }

    fun matches(s: String, p: String, i: Int, j: Int): Boolean {
        if (i == 0) {
            return false
        }
        return if (p[j - 1] == '.') {
            true
        } else s[i - 1] == p[j - 1]
    }

}

fun main() {
    val ex = MatchExpression()

//    println(ex.isMatch("aaab", "a*a*b"))
//    println(ex.isMatch("mississippi", "mis*is*p*."))
//    println(ex.isMatch("aaa", "a*a"))
//    println(ex.isMatch("ab", "a."))
//    println(ex.isMatch("aa", "a"))
//    println(ex.isMatch("aa", "a*"))

    println(ex.isMatch("aaaabbaa", "aa*ba*"))
}