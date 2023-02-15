package solution.microsoft.backtracking

import common.TreeNode

/*
* 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
* B是A的子结构， 即 A中有出现和B相同的结构和节点值。
* */
class SubTree {
    fun isSubStructure(A: TreeNode?, B: TreeNode?): Boolean {
        // return 首先 A、B 不为 null，其次检查 A 的子树是否与 B 相同
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B))
    }

    /*
    * 当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 true
    */
    private fun recur(A: TreeNode?, B: TreeNode?): Boolean {
        // 为什么 B == null return true？
        if(B == null) return true
        if(A == null || A.`val` != B.`val`) return false
        // 继续递归检查子节点是否一致
        return recur(A.left, B.left) && recur(A.right, B.right)
    }
}