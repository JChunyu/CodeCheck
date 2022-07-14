package slidewindow

import struct.ListNode

class RemoveNthFromEnd {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var node = head
        var prev = node
        var last = node

        for (i in 0 until n) {
            last = last?.next
        }
        // 这里是为什么呢
        if (last == null) {
            node = node?.next
            return node
        }

        while (last?.next != null) {
            last = last.next
            prev = prev?.next
        }
        prev?.next = prev?.next?.next
        return node
    }
}