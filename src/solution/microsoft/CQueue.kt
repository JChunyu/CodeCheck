package solution.microsoft

import java.util.Stack


/**
 * 用两个栈实现队列
 * Your CQueue object will be instantiated and called as such:
 * var obj = CQueue()
 * obj.appendTail(value)
 * var param_2 = obj.deleteHead()
 */

class CQueue() {

    var pushStack = Stack<Int>()
    var popStack = Stack<Int>()

    fun appendTail(value: Int) {
        pushStack.add(value)
    }

    fun deleteHead(): Int {
        while (pushStack.isNotEmpty()) {
            popStack.add(pushStack.pop())
        }
        val result = if (popStack.isNotEmpty()) {
            popStack.pop()
        } else {
            -1
        }

        while (popStack.isNotEmpty()) {
            pushStack.add(popStack.pop())
        }
        return result
    }
    /*
    * 知识点，pushStack 用来接收数据就行，popStack 用来删除数据
    * 所以 popStack 不为空时，直接删除并 return。
    * 若 popStack 为空时，才需要将 pushStack 的数据转移到 popStack 中
    * */
    fun deleteHeadBest(): Int {
        if (popStack.isNotEmpty()) {
            return popStack.removeFirst()
        }

        while (pushStack.isNotEmpty()) {
            popStack.add(pushStack.pop())
        }

        return if (popStack.isNotEmpty()) {
            popStack.pop()
        } else {
            -1
        }
    }

}