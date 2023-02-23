package algorithms.two_point

import common.ListNode

class RemoveNthFromEnd {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val prev = ListNode(-1).apply {
            next = head
        }
        var left: ListNode? = prev
        var right = head
        var step = n

        while (step > 0) { // 倒数第 n - 1 ge
            right = right?.next
            step--
        }

        while (right != null) {
            right = right.next
            left = left?.next
        }
        left?.next = left?.next?.next
        val ans = prev.next
        return ans
    }
}

fun main() {
    val r = RemoveNthFromEnd()
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

    var res = r.removeNthFromEnd(node1, 1)
    while (res != null) {
        println(res.value)
        res = res.next
    }

}