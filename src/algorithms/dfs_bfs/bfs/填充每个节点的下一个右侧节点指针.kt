package algorithms.dfs_bfs.bfs

import java.util.*


class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

/*
* 59/59 cases passed (208 ms)
* Your runtime beats 73.47 % of kotlin submissions
* Your memory usage beats 51.02 % of kotlin submissions (36.2 MB)
* */
class Solution116 {
    fun connect(root: Node?): Node? {
        bfs(root)
        return root
    }

    private fun bfs(root: Node?) {
        if (root == null) return
        val array = LinkedList<List<Node>>()
        val roots = listOf(root)
        array.add(roots)

        while (array.isNotEmpty()) {
            val currents = array.pop()
            // 指针向右
            for (i in currents.indices) {
                val nextIndex = i + 1
                if (nextIndex < currents.size) {
                    currents[i].next = currents[ i + 1]
                } else {
                    currents[i].next = null
                }
            }
            val nextRoots = arrayListOf<Node>()

            for (i in currents) {
                i.left?.let { nextRoots.add(it) }
                i.right?.let { nextRoots.add(it) }
            }
            if (nextRoots.isNotEmpty()) {
                array.add(nextRoots)
            }
        }
    }
}