package microsoft.backtracking

import common.struct.TreeNode

class MirrorTree {
    /*
    * 镜像二叉树，所有对left 节点 都替换成 right
    * 回溯算法 dfs 基础上进行交换左右节点
    * */
    fun mirrorTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        if (root.left != null) {
            mirrorTree(root.left)
        }
        if (root.right != null) {
            mirrorTree(root.right)
        }
        val temp = root.left
        root.left = root.right
        root.right = temp
        return root
    }
}