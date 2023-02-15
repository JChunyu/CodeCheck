package solution.leetcode

/*
 * @lc app=solution.leetcode.cn id=22 lang=kotlin
 *
 * [22] 括号生成
 */

// @lc code=start
class Q22 {

    fun test(n: Int) {
        val res = generateParenthesis(n)
        res.forEach {
            println(it)
        }
        println("total: ${res.size}")
    }

    fun generateParenthesis(n: Int): List<String> {
        val combinations = arrayListOf<String>()
//        generateAll(CharArray(2 * n), 0, combinations)
        backtrack(combinations, StringBuilder(), 0, 0, n)
        return combinations
    }

    // 1. 暴力递归
    private fun generateAll(current: CharArray, pos: Int, result: ArrayList<String>) {
        if (pos == current.size) { // 当前位置已到达最大容量 递归终止条件
            // 通过验证直接添加到结果中
            if (valid(current)) {
                result.add(current.concatToString())
            }
        } else { // 递归计数增加
            // 下一个添加左括号的情况
            current[pos] = '('
            generateAll(current, pos + 1, result)
            // 下一个添加右括号的情况
            current[pos] = ')'
            generateAll(current, pos + 1, result)
        }
    }

    // 检验序列是否合理
    private fun valid(current: CharArray): Boolean {
        var balance = 0
        for (c in current) {
            if (c == '(') {
                ++balance
            } else {
                --balance
            }
            if (balance < 0) {
                return false
            }
        }
        return balance == 0
    }

    // 2. 限制有效数量的解法（剪枝）
    fun backtrack(ans: ArrayList<String>, current: StringBuilder, open: Int, close: Int, max: Int) {
        // 当前字符串容量达到最大，将其添加到结果中
        if (current.length == max * 2) {
            ans.add(current.toString())
            return
        }
        // 左括号数量 open , 小于给定的 n 时，增加一个左括号
        if (open < max) {
            current.append('(')
            backtrack(ans, current, open + 1, close, max) // 递归
            current.deleteCharAt(current.length - 1) // ')' 情况下完成后，删除这次添加的括号的尝试，确保能够在这个位置尝试 '('
        }
        // 右括号数量 close，小于左括号数量时，增加一个右括号
        if (close < open) {
            current.append(')')
            backtrack(ans, current, open, close + 1, max) // 递归
            current.deleteCharAt(current.length - 1) // ')' 情况下完成后，删除这次添加的括号的尝试，确保能够在这个位置尝试 '('
        }
    }

    private val cache = ArrayList<List<String>?>()

//    fun generate(n: Int): List<String> {
//        if (cache.get(n) != null) {
//            return cache[n]
//        }
//        val ans = ArrayList<String>()
//        if (n == 0) {
//            ans.add("")
//        } else {
//            for (c in 0..n) {
//                for (left in generate(c)) {
//                    for (right in generate(n - 1 - c)) {
//                        ans.add("($left)$right")
//                    }
//                }
//            }
//        }
//        cache[n] = ans
//        return ans
//    }
}
// @lc code=end

/*
*/