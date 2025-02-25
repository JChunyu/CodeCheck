package algorithms.list_node

import common.ListNode
import kotlin.math.min


class ListNodeProj {
    /*
    * Q21: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    * 知识点：需要用一个节点作为起始位置标记，如果一个为空，后续不需要在继续遍历直接链接提高效率
    * */
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1
        val resCursor = ListNode(-1)
        var cursor: ListNode? = resCursor
        var l1Cursor = list1
        var l2Cursor = list2

        while (l1Cursor != null && l2Cursor != null) {
            if (l1Cursor.`val` <= l2Cursor.`val`) {
                cursor?.next = l1Cursor
                l1Cursor = l1Cursor.next
            } else {
                cursor?.next = l2Cursor
                l2Cursor = l2Cursor.next
            }
            cursor = cursor?.next
        }
        if (l1Cursor == null) {
            cursor?.next = l2Cursor
        }
        if (l2Cursor == null) {
            cursor?.next = l1Cursor
        }
        return resCursor.next
    }

    /*
    * 19. 删除链表的倒数第 N 个结点
    * 需要用一个索引节点来记录变更后的结果；删除单向链表中的元素要用待删除的节点的前一个的引用
    * */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) return null
        val res = ListNode(-1)
        var cursor1: ListNode? = res
        cursor1?.next = head
        var cursor2: ListNode? = head
        for (i in 1..n) {
            cursor2 = cursor2?.next
        }
        while (cursor2 != null) {
            cursor1 = cursor1?.next
            cursor2 = cursor2.next
        }
        cursor1?.next = cursor1?.next?.next
        return res.next
    }


    /*
    * 23. 合并 K 个升序链表
    * 思路是
    * 1. 第一个和第二个合并，然后结果再合并第三个，这样一直合并到最后一个，借助合并两个链表来实现
    * 2. 每一轮两两合并，log 指数次合并后为单一链表
    * */
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        var merged = lists.first()
        var i = 1
        while (i < lists.size) {
            merged = mergeTwoLists(merged, lists[i])
            i++
        }
        return merged
    }

    /*
    * 24. 两两交换链表中的节点
    * */
    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null) return null
        val ans = ListNode(0)
        ans.next = head
        var cursor0 = ans
        var cursor1 = head
        var cursor2 = head
        // 2 先走一步，确保双数
        cursor2 = cursor2.next

        while (cursor2 != null) {
            val temp = cursor2.next
            cursor0.next = cursor2
            cursor2.next = cursor1
            cursor1?.next = temp

            cursor1 = cursor1?.next
            cursor2 = cursor2.next
        }
        return ans.next
    }

}

fun main() {
    val n1 = ListNode(1)
    val n2 = ListNode(2)
    val n3 = ListNode(4)
    val m1 = ListNode(1)
    val m2 = ListNode(3)
    val m3 = ListNode(4)

    n1.next = n2
    n2.next = n3

    m1.next = m2
    m2.next = m3

    val listNodeProj = ListNodeProj()

    var node = listNodeProj.mergeTwoLists(n1, m1)
    while (node != null) {
        println(node.`val`)
        node = node.next
    }


    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
//    node1.next = node2
//    node2.next = node3
//    node3.next = node4
//    node4.next = node5
//    node5.next = null

    var res = listNodeProj.removeNthFromEnd(node1, 1)
    while (res != null) {
        println(res.`val`)
        res = res.next
    }
}

