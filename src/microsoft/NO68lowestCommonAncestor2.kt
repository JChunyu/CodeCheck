package microsoft

import common.struct.TreeNode

class NO68lowestCommonAncestor2 {
    /*
    * 思路
    * 1. p q 一个在左一个在右， root 为结果
    * 2. p q 都在左，继续检查 root.left
    * 3. p q 都在右，继续检查 root.right
    * 4. p q 有一个为 root，root 为结果
    * */
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if(root == null) {
            return null
        }
        //
        if (root == p || root == q) {
            return root
        }
        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)
        if (left != null && right != null) {
            return root
        } else if (left != null && right == null) {
            return left
        } else if (right != null && left == null) {
            return right
        }
        return null
    }
}