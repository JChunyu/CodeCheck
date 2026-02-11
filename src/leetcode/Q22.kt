package leetcode


/*
* 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
* 输入：n = 3
* 输出：["((()))","(()())","(())()","()(())","()()()"]
* */
fun generateParenthesis(n: Int): List<String> {
    if (n <= 0) return emptyList()
    val res = arrayListOf<String>()
    val left = '('
    val right = ')'
    val stringBuffer = StringBuffer()

    // 用于判断字符串是否有效
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        for (c in s) {
            if (c == left) {
                stack.addLast(c)
            } else if (c == right) {
                if (stack.isEmpty()) {
                    return false
                }
                stack.removeLast()
            }
        }
        return stack.isEmpty()
    }

    // 回溯算法
    fun backtrack(open: Int, close: Int) {
        if (stringBuffer.length == 2 * n) {
            val str = stringBuffer.toString()
            if (isValid(str)) {
                res.add(str)
            }
            return
        }
        if (open < n) {
            stringBuffer.append(left)
            backtrack(open + 1, close)
            stringBuffer.deleteCharAt(stringBuffer.length - 1)
        }
        if (close < n) {
            stringBuffer.append(right)
            backtrack(open, close + 1)
            stringBuffer.deleteCharAt(stringBuffer.length - 1)
        }
    }
    backtrack(0, 0)
    return res
}

/*
*
if (满足结束条件) { 收集结果; return }
 for (选择 in 可选列表) {
 做选择 backtrack(新的状态)
 撤销选择 }
}
* */