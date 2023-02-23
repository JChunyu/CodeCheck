package algorithms.dfs_bfs


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/*执行用时：
224 ms
, 在所有 Kotlin 提交中击败了
80.00%
的用户
内存消耗：
36.6 MB
, 在所有 Kotlin 提交中击败了
70.00%
的用户*/
class MergeBinaryTree {

    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        if (root1 == null && root2 == null) return null
        if (root1 == null && root2 != null) return root2
        if (root1 != null && root2 == null) return root1
        val result = TreeNode(root1!!.`val` + root2!!.`val`)
        dfs(result, root1, root2)
        return result
    }

    private fun dfs(result: TreeNode, root1: TreeNode?, root2: TreeNode?) {
        // 处理左侧节点
        if (root1?.left == null && root2?.left == null) {
            result.left = null
        } else {
            val root1Left = root1?.left?.`val` ?: 0
            val root2Left = root2?.left?.`val` ?: 0
            result.left = TreeNode(root1Left + root2Left)
            dfs(result.left!!, root1?.left, root2?.left)
        }
        if (root1?.right == null && root2?.right == null) {
            result.right = null
        } else {
            val root1R = root1?.right?.`val` ?: 0
            val root2R = root2?.right?.`val` ?: 0
            result.right = TreeNode(root1R + root2R)
            dfs(result.right!!, root1?.right, root2?.right)
        }
    }
}