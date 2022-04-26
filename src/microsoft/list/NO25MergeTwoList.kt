package microsoft.list

import struct.ListNode


class NO25MergeTwoList {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val node = ListNode(-1)
        var current: ListNode? = node
        var n1 = l1
        var n2 = l2
        var last: ListNode? = null

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