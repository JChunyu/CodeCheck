package microsoft

import common.struct.TreeNode

class NO55isBalanced {
    fun isBalanced(root: TreeNode?): Boolean {
        return height(root) >= 0
        return false
    }

    private fun height(root: TreeNode?): Int {
        if (root == null) return 0
        val l = height(root.left)
        val r = height(root.right)

        return if (Math.abs(l - r) > 1 || l == -1 || r == -1) {
            -1
        } else {
            Math.max(height(root.left), height(root.right)) + 1
        }
    }
}