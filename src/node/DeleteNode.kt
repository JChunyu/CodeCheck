package node

import common.struct.ListNode

class DeleteNode {
    fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
        val fakerNode = ListNode(-1)
        fakerNode.next = head
        var temp: ListNode? = fakerNode
        while (temp?.next != null) {
            if (temp.next?.value == `val`) {
                temp.next = temp.next?.next
            } else {
                temp = temp.next
            }
        }
        return fakerNode.next
    }
}