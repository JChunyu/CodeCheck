package microsoft.list

import common.struct.ListNode

class Solution {
    fun reverse(head: ListNode?): ListNode? {
        var node = head
        var reverse: ListNode? = null
        while (node != null) {
            val temp = node.next
            node.next = reverse
            reverse = node
            node = temp
        }
        return reverse
    }
}









class ReverseList {
    fun reverseList(head: ListNode?): ListNode? {
        var node = head
        var reverse: ListNode? = null
        while (node != null) {
            val temp = node.next
            node.next = reverse
            reverse = node
            node = temp
        }
        return reverse
    }
}

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    var a = ReverseList().reverseList(node1)

    while (a != null) {
        println(a.value)
        a = a.next
    }
}