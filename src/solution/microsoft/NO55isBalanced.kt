package solution.microsoft

import common.TreeNode

class NO55isBalanced {
    fun isBalanced(root: TreeNode?): Boolean {
        return if (root == null) {
            true
        } else {
            // 左右子树最大深度不超过 1
            val isBalance: Boolean = Math.abs(treeHeight(root.left) - treeHeight(root.right)) <= 1
            // 确保左子树，右子树也是平衡的
            isBalance && isBalanced(root.left) && isBalanced(root.right)
        }
    }

    private fun treeHeight(root: TreeNode?): Int {
        return if (root == null) {
            0
        } else {
            Math.max(treeHeight(root.left), treeHeight(root.right)) + 1
        }
    }

    fun isBalanced2(root: TreeNode?): Boolean {
        return checkHeight(root) >= 0
    }

    private fun checkHeight(root: TreeNode?): Int {
        if (root == null) return 0
        val leftHeight = checkHeight(root.left)
        val rightHeight = checkHeight(root.right)
        return if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            -1
        } else {
            Math.max(leftHeight, rightHeight) + 1
        }
    }
}