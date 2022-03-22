package microsoft.backtracking

import common.struct.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/*
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
* */
class LevelOrder {
    fun levelOrder(root: TreeNode?): IntArray {
        val list = LinkedList<ArrayList<TreeNode>>() // 存每一层数据
        val result = ArrayList<Int>()
        if (root != null) {
            list.add(arrayListOf(root))
        } else {
            return intArrayOf()
        }
        while (list.isNotEmpty()) {
            val currentLayerNodes = list.poll()
            val nextLayers = arrayListOf<TreeNode>()
            currentLayerNodes.forEach { it ->
                result.add(it.`val`)
                it.left?.let { left ->
                    nextLayers.add(left)
                }
                it.right?.let { right ->
                    nextLayers.add(right)
                }
            }
            if (currentLayerNodes.isNotEmpty()) {
                list.add(nextLayers)
            }
        }
        return result.toIntArray()
    }

    fun levelOrder2(root: TreeNode?): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        if (root == null) return result
        val list = LinkedList<TreeNode>()
        list.add(root)
        while (list.isNotEmpty()) {
            val size = list.size
            val temList = ArrayList<Int>()
            for (i in 0 until size) {
                val current = list.poll()
                temList.add(current.`val`)
                current.left?.let { left ->
                    list.add(left)
                }
                current.right?.let { right ->
                    list.add(right)
                }
            }
            result.add(temList)
        }
        return result
    }

    /*
    * 请实现一个函数按照之字形顺序打印二叉树，
    * 即第一行按照从左到右的顺序打印，
    * 第二层按照从右到左的顺序打印，
    * 第三行再按照从左到右的顺序打印，其他行以此类推。
    * */
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        if (root == null) {
            return result
        }
        val queue = LinkedList<ArrayList<TreeNode>>() // 存每一层数据
        queue.add(arrayListOf(root))
        var seq = true
        while (queue.isNotEmpty()) {
            val curLayers = queue.poll()
            val nextLayers = arrayListOf<TreeNode>()
            val curRes = arrayListOf<Int>()
            seq = !seq
            if (seq) {
                val temp = curLayers.reversed()
                curLayers.clear()
                curLayers.addAll(temp)
            }
            curLayers.forEach { it ->
                curRes.add(it.`val`)
                it.left?.let { left ->
                    nextLayers.add(left)
                }
                it.right?.let { right ->
                    nextLayers.add(right)
                }
            }
            if (curLayers.isNotEmpty()) {
                queue.add(nextLayers)
                result.add(curRes)
            }
        }
        return result
    }
}

fun main() {
    val levelOrder = LevelOrder()
    val treeNode1 = TreeNode(3)
    val treeNode2 = TreeNode(9)
    val treeNode3 = TreeNode(20)
    val treeNode4 = TreeNode(15)
    val treeNode5 = TreeNode(7)

    treeNode1.left = treeNode2
    treeNode1.right = treeNode3
    treeNode3.left = treeNode4
    treeNode3.right = treeNode5

    levelOrder.levelOrder3(treeNode1)
}