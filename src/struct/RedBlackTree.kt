package struct

import kotlin.test.todo

/*
* 定义：
* 1. 节点是红色或者黑色
* 2. 根节点是黑色
* 3. 每个叶子节点都是黑色的空节点
* 4. 每个红色节点的两个子节点都是黑色
*    - 推论1：从叶子即诶点到根节点的所有路径上，不会出现两个连续的红色节点
* 5. 从任意一个节点到它自己的每个叶子节点的所有路径都包含相同数目的黑色节点。
*
* 优点：
* 红黑树能够保证自平衡，从根节点到叶子节点的最长路径不超过最短路径的 2 倍。
*
* 插入和删除导致的调整，有两种解决办法：变色和旋转。旋转包括左旋（逆时针）和右旋(顺时针)， 表示 向左旋转和向右旋转
*
* 插入新节点是，默认是红色
*
* 变色：改变自身
* 左旋转：父节点被自己的右节点替代，自己成为自己的左节点
* 右旋转：父节点被自己的左节点替代，自己成为自己的右节点
*
* 五种调整规则：
* 1. 新节点位于根，没有父节点：这种情况直接让新节点变成黑色
* 2. 新节点的父节点是黑色：这种情况规则没有打破，无需调整
* 3. 新节点的父节点和叔叔节点都是红色：这种情况，自身是红色，父亲节点也是红色，违反了规则4
*    - 先让父节点变成黑色，再让爷爷节点变成红色，再让叔叔节点变黑
* 4. 新节点的父节点是红色，叔叔节点是黑色或者不存在，且新节点是父节点的右节点，父节点是爷爷节点的左孩子：
*    - 以父节点为轴，进行一次左旋转，新节点会替代原来的父节点，原来的父节点会变成新节点的左孩子，当前情况变成情况5
* 5. 新节点的父节点是红色，叔叔节点是黑色或者不存在，新节点是父节点的左孩子，父节点是爷爷节点的左孩子：
*    - 以爷爷节点进行右旋转，父节点替代爷爷节点，爷爷节点变成父节点的右节点，然后改变父节点的颜色为黑色，爷爷节点的颜色为红色。
*
* 若情况4中，父节点是爷爷节点的右孩子，则变成了情况 5 的镜像情况，情况 5 右旋变为左旋，然后会变成情况 4 的镜像情况，情况 4 的左旋变成右旋，再变色。
*
* E 是可对比的？因为红黑树是一个自平衡二叉树，其元素要有能够排序的能力。所以是实现 Comparable 接口的
* */
sealed class RedBlackTree<E: Comparable<E>> {
    // 定义颜色
    enum class Color { R, B}

    companion object {
        fun <T: Comparable<T>> emptyTree(): RedBlackTree<T> = Empty as RedBlackTree<T>
    }

    // 空树
    object Empty: RedBlackTree<Nothing>()

    data class Tree<E: Comparable<E>>(
        val color: Color,
        var left: RedBlackTree<E>,
        var right: RedBlackTree<E>,
        var element: E
    ): RedBlackTree<E>() {
        fun balance(): Tree<E> {
            // 根节点是黑色，左子树是红色
            if (color == Color.B) {
                if (left is Tree<E> && (left as Tree<E>).color == Color.R) {
                    val tempLeft = left as Tree<E>
                    if (tempLeft.left is Tree<E> && (tempLeft.left as Tree<E>).color == Color.R) {
                        return buildBalancedTree(
                            leftLeft = (tempLeft.left as Tree<E>).left,
                            leftElement = (tempLeft.left as Tree<E>).element,
                            leftRight = (tempLeft.left as Tree<E>).right,
                            midElement = tempLeft.element,
                            rightLeft = tempLeft.right,
                            rightElement = this.element,
                            rightRight = this.right
                        )
                    } else if (tempLeft.right is Tree<E> && (tempLeft.right as Tree<E>).color == Color.R) {
                        return buildBalancedTree(
                            leftLeft = tempLeft.left,
                            leftElement = tempLeft.element,
                            leftRight = tempLeft.right,
                            midElement = (tempLeft.right as Tree<E>).element,
                            rightLeft = (tempLeft.right as Tree<E>).right,
                            rightElement = this.element,
                            rightRight = this.right
                        )
                    }
                }

                if (right is Tree<E> && (right as Tree<E>).color == Color.R) {
                    val tempRight = right as Tree<E>
                    if (tempRight.left is Tree<E> && (tempRight.left as Tree<E>).color == Color.R) {
                        return buildBalancedTree(
                            leftLeft = this.left,
                            leftElement = this.element,
                            leftRight = (tempRight.left as Tree<E>).left,
                            midElement = (tempRight.left as Tree<E>).element,
                            rightLeft = (tempRight.left as Tree<E>).right,
                            rightElement = tempRight.element,
                            rightRight = tempRight.right
                        )
                    } else if (tempRight.right is Tree<E> && (tempRight.right as Tree<E>).color == Color.R) {
                        return buildBalancedTree(
                            leftLeft = this.left,
                            leftElement = this.element,
                            leftRight = tempRight.left,
                            midElement = tempRight.element,
                            rightLeft = (tempRight.right as Tree<E>).left,
                            rightElement = (tempRight.right as Tree<E>).element,
                            rightRight = (tempRight.right as Tree<E>).right
                        )
                    }
                }
            }
            return this
        }

        private fun buildBalancedTree(
            leftLeft: RedBlackTree<E>,
            leftElement: E,
            leftRight: RedBlackTree<E>,
            midElement: E,
            rightLeft: RedBlackTree<E>,
            rightElement: E,
            rightRight: RedBlackTree<E>
        ) = Tree(
            color = Color.R,
            left = Tree(Color.B, leftLeft, leftRight, leftElement),
            right = Tree(Color.B, rightLeft, rightRight, rightElement),
            element = midElement
        )
    }

    /*
    * 检查是否包含某元素，如果是 空树，直接false
    * - 如果 元素值大于当前节点，向右查找
    * - 如果 元素值小于当前节点，向左查找
    * - 最后的情况是 = 当前节点，return true
    * */
    fun contains(element: E): Boolean = when (this) {
        Empty -> false
        is Tree -> when {
            element < this.element -> left.contains(element)
            element > this.element -> right.contains(element)
            else -> true
        }
    }

    /*
    * 插入元素时，
    * - 空树直接插入，并标记节点为红色
    * - 插入元素小于树的当前节点，向左旋转，然后平衡一下树
    * - 插入元素大于树的当前节点，向右旋转，平衡树
    * - 等于当前树的值，直接返回？
    * */
    fun insert(element: E): Tree<E> {
        fun insertInto(tree: RedBlackTree<E>): Tree<E> = when(tree) {
            // 空树时插入为红色
            Empty -> Tree(Color.R, tree, tree, element)
            is Tree -> when {
                element < tree.element -> tree.copy(left = insertInto(tree.left).balance())
                element > tree.element -> tree.copy(right = insertInto(tree.right).balance())
                else -> tree
            }
        }
        return insertInto(this).copy(color = Color.B)
    }
}