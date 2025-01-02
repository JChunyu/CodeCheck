package leetcode

class WordBreakSolution {
    fun wordBreak2(s: String, wordDict: List<String>): Boolean {
        if (s.isEmpty()) return false
        var start = 0
        var end = 0
        while (end <= s.length) {
            val substring = s.substring(start, end)
            if (wordDict.contains(substring)) {
                start = end
            }
            end++
        }
        return start == s.length
    }

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length + 1)
        dp[0] = true
        for (i in 1 .. s.length) {
            for (j in 0 until i) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true
                    break
                }
            }
        }
        return dp[s.length]
    }
}

fun main() {
    println(WordBreakSolution().wordBreak("aaaaaaa", arrayListOf("aaaa", "aaa")))
}










/*
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。

注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     注意，你可以重复使用字典中的单词。
输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false

f(n) = f(n - 1) & wordDict.contains(s.substring[n - 1, n])
f(n - 1) = f(n - 2) wordDict.contains(s.substring[n - 2, n - 1])


f(n) = f(n - x) & wordDict.contains(s.substring[n - x, n])



f(0) = wordDict.contains(s.substring[0, 0])
f(1) = wordDict.contains(s.substring[0, 1])
f(2) = f(1) & wordDict.contains(s.substring[1, 2])
 */