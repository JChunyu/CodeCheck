package leetcode

import java.util.*

/*
* 232. 用栈实现队列
* */
class MyQueue() {
    private val stackA = Stack<Int>()
    private val stackB = Stack<Int>()

    fun push(x: Int) {
        stackA.push(x)
    }

    fun pop(): Int {
        if (stackA.isNotEmpty()) {
            while (stackA.isNotEmpty()) {
                stackB.push(stackA.pop())
            }
            val res = stackB.pop()
            while (stackB.isNotEmpty()) {
                stackA.push(stackB.pop())
            }
            return res
        } else {
            throw NoSuchElementException("Queue is empty")
        }
    }

    fun peek(): Int {
        if (stackA.isNotEmpty()) {
            while (stackA.isNotEmpty()) {
                stackB.push(stackA.pop())
            }
            val res = stackB.peek()
            while (stackB.isNotEmpty()) {
                stackA.push(stackB.pop())
            }
            return res
        } else {
            throw NoSuchElementException("Queue is empty")
        }
    }

    fun empty(): Boolean {
        return stackA.isEmpty()
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */


class MyQueue1() {
    private var currentStack = Stack<Int>()
    private var otherStack = Stack<Int>()

    fun push(x: Int) {
        if (currentStack.isEmpty()) {
            currentStack.push(x)
        } else {
            otherStack.push(x)
        }
    }

    fun pop(): Int {
        val res = currentStack.pop()
        if (currentStack.isEmpty()) {
            while (otherStack.isNotEmpty()) {
                currentStack.push(otherStack.pop())
            }
        }
        return res
    }

    fun peek(): Int {
        return currentStack.peek()
    }

    fun empty(): Boolean {
        return currentStack.isEmpty() && otherStack.isEmpty()
    }
}