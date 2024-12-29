package solution.annotation

fun main() {
    val a = SolutionA()
    // val input = readLine()
    var root: SolutionA.TreeNode = SolutionA.TreeNode()
    root.value = 1

    var treeNode2: SolutionA.TreeNode = SolutionA.TreeNode()
    treeNode2.value = 2

    var treeNode3: SolutionA.TreeNode = SolutionA.TreeNode()
    treeNode3.value = 3

    var treeNode4: SolutionA.TreeNode = SolutionA.TreeNode()
    treeNode4.value = 4

    var treeNode5: SolutionA.TreeNode = SolutionA.TreeNode()
    treeNode5.value = 5

    var treeNode6: SolutionA.TreeNode = SolutionA.TreeNode()
    treeNode6.value = 6

    root.left = treeNode2
    root.right = treeNode3
    treeNode2.left = treeNode4
    treeNode3.left = treeNode5
    treeNode3.right = treeNode6

    a.printNode(root)
}

class SolutionA {

    fun printNode(node: TreeNode) {
        val res = arrayListOf<ArrayList<TreeNode?>>()
        var curArray = arrayListOf<TreeNode?>()
        var order = true
        curArray.add(node)

        while(curArray.isNotEmpty()) {
            val tempList = arrayListOf<TreeNode?>()
            curArray.forEach { i ->
                tempList.add(i?.left)
                tempList.add(i?.right)
            }
            res.add(tempList)
            curArray = tempList
        }

        res.forEach { list ->
            if(order) {
                list.forEach { it -> print(it?.value) }
            } else {
                list.reverse()
                list.forEach { it -> print(it?.value) }
            }
            order = !order
        }
    }


    class TreeNode(
        var value: Int? = null,
        var left: TreeNode? = null,
        var right: TreeNode? = null
    )
}