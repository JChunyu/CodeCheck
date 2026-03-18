package leetcode

import common.TreeNode

class IsSameTreeSolution {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return false
        return if (p?.`val` == q?.`val`) {
            isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
        } else {
            false
        }
    }
}