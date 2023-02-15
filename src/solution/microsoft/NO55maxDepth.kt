package solution.microsoft

import common.TreeNode

class NO55maxDepth {
    var maxLayer = 0
    fun maxDepth(root: TreeNode?): Int {
        root?.let {
            deepMap(it, 1)
            return maxLayer
        }
        return 0
    }

    fun deepMap(root: TreeNode, layer: Int) {
        maxLayer = Math.max(layer, maxLayer)
        root.left?.let {
            deepMap(it, layer + 1)
        }
        root.right?.let {
            deepMap(it, layer + 1)
        }
    }
}

fun main() {
    val treeNode1 = TreeNode(1)
    val treeNode2 = TreeNode(2)
    val treeNode3 = TreeNode(3)
    val treeNode4 = TreeNode(4)
    val treeNode5 = TreeNode(5)
    val treeNode6 = TreeNode(6)
    treeNode5.left = treeNode3
    treeNode5.right = treeNode6
    treeNode3.left = treeNode2
    treeNode3.right = treeNode4
    treeNode2.left = treeNode1

    NO55maxDepth().maxDepth(treeNode5)
}