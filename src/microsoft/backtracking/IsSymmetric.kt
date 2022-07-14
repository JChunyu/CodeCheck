package microsoft.backtracking

import common.struct.TreeNode

class IsSymmetric {
    /*
    * 判断二叉树是否对称
    *
    * 分析流程：
    * - root = null, return true
    * - root != null, return recur(root.left, root.right)
    *
    * recur 的内部流程
    * - left.val != right.val, return false
    * - left = null || right = null, return false
    * - left = null && right = null, teturn true
    * - left.left.val = right.right.val && left.right.val = right.left.val, return true
    *
    *
    * 思路还是用递归，用一个辅助函数进行左右比较，然后再去比较左右节点的子节点。
    * */
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        return recur(root.left, root.right)
    }

    private fun recur(l: TreeNode?, r: TreeNode?): Boolean {
        if (l == null && r == null) return true
        if (l == null || r == null || l.`val` != r.`val`) return false
        return recur(l.left, r.right) && recur(l.right, r.left)
    }
}