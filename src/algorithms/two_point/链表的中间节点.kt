package algorithms.two_point

import common.ListNode

class MiddleNode {
    fun middleNode(head: ListNode?): ListNode? {
        var node = head
        var size = 0
        while (node != null) {
            node = node.next
            size++
        }

        var mid = size / 2
        var res = head

        while (mid > 0) {
            res = res?.next
            mid--
        }
        return res
    }


    fun middleNode2(head: ListNode?): ListNode? {
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