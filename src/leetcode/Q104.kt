package leetcode

import common.TreeNode
import kotlin.math.max


/*
给定一个二叉树 root ，返回其最大深度。

二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
* */
class Q104 {
    fun maxDepth(root: TreeNode?): Int {
        return deep(root)
    }

    fun deep(node: TreeNode?): Int {
        if (node == null) return 0
        return max(deep(node.left) + 1, deep(node.right) + 1)
    }
}