package solution.microsoft.backtracking

import common.TreeNode

class SimpleDemo {
    /*
    * 递归，x 的 n 阶乘
    * 在数学中，可以定义为：
    * n = 0，result = 1
    * n > 0, result = x * fact(n - 1)
    * */
    fun fact(x: Int, n: Int): Int {
        return if (n == 0) {
            1
        } else {
            x * fact(x, n - 1)
        }
    }

    /*
    * 尾递归
    * 示例，斐波那契数列
    * 指递归函数在调用自身后直接传回其值，而不对其再加运算。( 递归调用返回的结果总被直接返回，则称为尾部递归。）
    * 尾部递归与循环是等价的，而且在一些语言（如Scheme中）可以被优化为循环指令。 因此，在这些语言中尾部递归不会占用调用堆栈空间。
    * */


    /*
    * 斐波那契数列
    * f(0) = 1
    * f(1) = 1
    * f(2) = 2
    * f(3) = 3
    * f(4) = 5
    * f(5) = 8
    * f(6) = 13
    * */
    fun fillbro(n: Int): Int {
        return if (n == 0 || n == 1) {
            1
        } else {
            fillbro(n - 1) + fillbro(n - 2)
        }
    }

    /*
    * 递归，常用于解决例如：斐波那契数列。
    * 常用于数据结构：树结构、广义表等。
    * */

    /*
    * 递归处理 TreeNode
    * 常见对树结构的递归处理是 深度优先遍历
    * */

    fun dfs(node: TreeNode?) {
        if (node == null) {
            return
        }
        println(node.`val`)
        if (node.left != null) {
            dfs(node.left)
        }
        if (node.right != null) {
            dfs(node.right)
        }
    }
}

fun main() {
//    val r = SimpleDemo().fact(2, 4)
//    println(r)
//
//    val f = SimpleDemo().fillbro(6)
//    println(f)
    //  5 、3、1、4、7、9
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node4 = TreeNode(4)
    val node5 = TreeNode(5)
    val node6 = TreeNode(6)
    val node7 = TreeNode(7)
    val node8 = TreeNode(8)
    val node9 = TreeNode(9)

    node5.left = node3
    node5.right = node7
    node3.left = node1
    node3.right = node4
    node7.right = node9

    SimpleDemo().dfs(node5)
}