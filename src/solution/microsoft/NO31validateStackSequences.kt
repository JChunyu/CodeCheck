package solution.microsoft

import java.util.*

class NO31validateStackSequences {
    /*
    * [1,2,3,4,5], [4,5,3,2,1]
    * */
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = Stack<Int>()
        var i = 0 // i 是对 popped 进行遍历，当 popped 遍历完，如果 stack 为空，说明全都出栈了。
        for (entry in pushed) {
            stack.push(entry)
            while (i < popped.size && stack.isNotEmpty() && stack.peek() == popped[i]) {
                stack.pop()
                i++
            }
        }
        return i == popped.size
    }
}