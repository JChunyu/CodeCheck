package node

import struct.ListNode

class KthFromEnd {
    fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
        var temp: ListNode? = head
        var node: ListNode? = head
        var i = k
        while (i > 0) {
            temp = temp?.next
            i--
        }
        while (temp?.next != null) {
            temp = temp.next
            node = node?.next
        }
        return node
    }
}