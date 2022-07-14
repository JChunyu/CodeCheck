package microsoft

import java.util.*

class NO33verifyPostorder {

    /*
    * 后序遍历的顺序结构是 【左子树｜右子树｜根】
    * 二叉树中所有左子树的值都小于根，右子树的值都大于根。
    * */

    // 方法一，使用递归处理 时间复杂度 O(N^2) 空间复杂度 O(N)，最差情况下（即当树退化为链表），递归深度将达到 N 。
    // 终止条件 所有的左子树中的节点值都小于根，所有都右子树的节点值都大于根，其所有子树也满足这个条件。
    fun verifyPostorder(postorder: IntArray): Boolean {
        return recur(postorder, 0, postorder.size - 1)
    }

    private fun recur(postorder: IntArray, start: Int, end: Int): Boolean {
        if (start >= end) return true
        var m = start
        // 左子树区域 0 -- m - 1, 一定满足 postorder[i] < postorder[j]
        while (postorder[m] < postorder[end]) {
            m++
        }
        var n = m
        // 右子树区域 m -- j - 1, 一定满足 postorder[i] > postorder[j]
        while (postorder[n] > postorder[end]) {
            n++
        }
        // n 最后的值是 end
        return n == end && recur(postorder, start, m - 1) && recur(postorder, m , end - 1)
    }

    // 方法2，辅助单调栈
    // 后序遍历倒序： [ 根节点 | 右子树 | 左子树 ] 。类似 先序遍历的镜像
    // 即先序遍历为 “根、左、右” 的顺序，而后序遍历的倒序为 “根、右、左” 顺序。
    // 遇到降序时，第一个降序的节点一定是最接近 root ，并且它的右子树中的节点都小于 root
    fun verifyPostorder2(postorder: IntArray): Boolean {
        val stack = Stack<Int>()
        var root = Int.MAX_VALUE
        for (i in postorder.size - 1 downTo 0) {
            if (postorder[i] > root) return false
            while (stack.isNotEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop()
            }
            stack.add(postorder[i])
        }
        return true
    }

    // 方法三
    // 已知：
    // ①二叉搜索树的中序遍历一定是有序的
    // ②中序序列和后序序列可以唯一确定一棵树
    // 那么可以将postOrder排序得到中序序列，尝试由中序和后序序列构建二叉树
    // 若能构建成功，则后序序列合法；否则不合法
    fun verifyPostorder3(postorder: IntArray): Boolean {
        val newArray = postorder
        newArray.sort()
        return verify(newArray, 0, postorder.size - 1, postorder, 0, postorder.size - 1);
    }

    fun verify(array: IntArray, start: Int, end: Int, lastArray: IntArray, lStart: Int, lEnd: Int): Boolean {
        if (start > end) return true
        var root = lastArray[lEnd]
        var k = start
        while (k <= end && array[k] != root) {
            k++
        }
        if (k > end) {
            return false
        }
        return verify(array, start, k - 1, lastArray, lStart, lStart + k - start - 1) && verify(array, k + 1, end, lastArray, lStart + k - start, lEnd - 1)
    }

}