package slidewindow

import common.struct.ListNode


class MidNode {
    fun middleNode(head: ListNode?): ListNode? {
        var size = 1
        var node = head
        while (node?.next != null) {
            node = node.next
            size++
        }
        var midIndex = size / 2
        node = head
        while (midIndex > 0) {
            node = node?.next
            midIndex--
        }
        return node
    }
}