package todo

import common.struct.TreeNode
import java.util.*

class CheckSameX {
    fun find(node: TreeNode, x: Int): List<TreeNode?> {
        val queue = LinkedList<List<TreeNode?>>()
        queue.add(listOf(node))

        while (queue.isNotEmpty()) {
            val curLayer = queue.pop() // cur layer
            val realInts = curLayer.map {
                it?.`val`
            }
            if (realInts.contains(x)) {
                return curLayer.filter {
                    it?.`val` == x
                }
            }
            val nextLayer = arrayListOf<TreeNode?>()

            curLayer.forEach {
                if (it?.left != null) {
                    nextLayer.add(it.left)
                }

                if (it?.right != null) {
                    nextLayer.add(it.right)
                }
            }
            queue.add(nextLayer)
        }
        return emptyList()
    }
}