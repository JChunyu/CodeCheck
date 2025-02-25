package algorithms.data_structure.linked_list

import algorithms.list_node.ListNodeProj
import common.ListNode

class MergeTwoLists {

    fun mergeTwoLists2(l1: common.ListNode?, l2: common.ListNode?): common.ListNode? {
        if (l1 == null && l2 == null) return null
        if (l1 == null && l2 != null) return l2
        if (l1 != null && l2 == null) return l1
        val res = common.ListNode(-1)
        var head: common.ListNode
        var a = l1
        var b = l2
        res.next = a
        while (a != null && b != null) {
            if (a.`val` < b.`val`) {
                head = a
                a = a.next
            } else {
                res.next = b
                b = b.next
            }
        }
        return res.next
    }

    fun mergeTwoLists3(l1: common.ListNode?, l2: common.ListNode?): common.ListNode? {
        val node = common.ListNode(-1)
        var current: common.ListNode? = node
        var n1 = l1
        var n2 = l2
        var last: common.ListNode? = null

        while (n1 != null && n2 != null) {
            if (n1.`val` >= n2.`val`) {
                current?.next = n2
                n2 = n2.next
            } else {
                current?.next = n1
                n1 = n1.next
            }
            current = current?.next
        }
        if (n1 != null) {
            last = n1
        }
        if (n2 != null) {
            last = n2
        }
        current?.next = last
        return node.next
    }
}
