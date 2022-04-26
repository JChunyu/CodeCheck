package microsoft

import common.struct.TreeNode

class NO54KthLargest {

    val sortList = ArrayList<Int>()

    fun kthLargest(root: TreeNode?, k: Int): Int {
        root?.let {
            deepSort(it)
            println(sortList[sortList.size - k])
            return sortList[sortList.size - k]
        }
        return -1
    }

    private fun deepSort(root: TreeNode) {
        root.left?.let {
            deepSort(it)
        }
        sortList.add(root.`val`)
        root.right?.let {
            deepSort(it)
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

    NO54KthLargest().kthLargest(treeNode5, 2)
}