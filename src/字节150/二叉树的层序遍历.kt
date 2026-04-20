package 字节150

import common.TreeNode
import java.util.LinkedList

class LevelOrderSolution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val rowArray = arrayListOf<List<Int>>()
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            var size = queue.size
            val levels = arrayListOf<Int>()
            while (size > 0) {
                val temp = queue.removeFirst()
                levels.add(temp.`val`)
                temp.left?.let {
                    queue.add(it)
                }
                temp.right?.let {
                    queue.add(it)
                }
                size--
            }
            rowArray.add(levels)
        }
        return rowArray
    }
}