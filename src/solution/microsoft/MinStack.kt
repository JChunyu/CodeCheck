package solution.microsoft

import java.util.Stack


/**
 * 包含 min 函数的湛
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.min()
 */
class MinStack() {

    /** initialize your data algorithms.structure here. */
    var stack = Stack<Int>()
    var minStack = Stack<Int>()
    var min = Int.MAX_VALUE

    fun push(x: Int) {
        stack.add(x)
        min = if (min > x) {
            x
        } else {
            min
        }
        minStack.add(min)
    }

    fun pop() {
        stack.pop()
        minStack.pop()
        // 注意每次 pop ， min 最小值会发生变化。
        min = if (minStack.isEmpty()) {
            Int.MAX_VALUE
        } else {
            minStack.peek()
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun min(): Int {
        return minStack.peek()
    }
}