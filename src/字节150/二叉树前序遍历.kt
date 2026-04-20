package 字节150

import common.TreeNode

class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val ans = arrayListOf<Int>()
        traversal(ans, root)
        return ans
    }

    // 前序
    fun traversal(list: ArrayList<Int>, root: TreeNode?) {
        if (root == null) return
        list.add(root.`val`)
        traversal(list, root.left)
        traversal(list, root.right)
    }
    // 中序
    fun traversal2(list: ArrayList<Int>, root: TreeNode?) {
        if (root == null) return
        traversal(list, root.left)
        list.add(root.`val`)
        traversal(list, root.right)
    }

    // 后序
    fun traversal3(list: ArrayList<Int>, root: TreeNode?) {
        if (root == null) return
        traversal(list, root.left)
        traversal(list, root.right)
        list.add(root.`val`)
    }
}