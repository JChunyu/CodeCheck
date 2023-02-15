package solution.microsoft

import common.TreeNode
import java.util.*

class NO07BuildTree {
    /*
    * 思路
    * 前序排列，第一个元素是 root
    * 中序排列，查找到 index 位置为 root
    * 查找出 root 的 index 后，以 index 划分左侧和右侧为左子树和右子树范围
    * 然后对左边和右边进行递归查找子树的 root
    * */
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val n = preorder.size
        if (n == 0) return null
        val root = preorder[0]
        var rootIndex = 0
        for (i in preorder.indices) {
            if (inorder[i] == root) {
                rootIndex = i
                break
            }
        }
        val node = TreeNode(root)
        // 前序排列忽略第一个元素，中序排列忽略 index 元素
        // copy 的是 from index to 数组长度
        node.left = buildTree(Arrays.copyOfRange(preorder, 1,rootIndex + 1), Arrays.copyOfRange(inorder, 0, rootIndex))
        node.right = buildTree(Arrays.copyOfRange(preorder, rootIndex + 1, n), Arrays.copyOfRange(inorder, rootIndex + 1, n))
        return node
    }
}