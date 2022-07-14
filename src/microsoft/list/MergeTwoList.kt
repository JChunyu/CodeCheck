package microsoft.list

import common.struct.ListNode


class MergeTwoList {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) return null
        if (l1 == null && l2 != null) return l2
        if (l1 != null && l2 == null) return l1
        val res = ListNode(-1)
        var head: ListNode
        var a = l1
        var b = l2
        res.next = a
        while (a != null && b != null) {
            if (a.value < b.value) {
                head = a
                a = a.next
            } else {
                res.next = b
                b = b.next
            }
        }
        return res.next
    }
}