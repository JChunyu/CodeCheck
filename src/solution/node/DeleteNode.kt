package solution.node

import common.ListNode

/*
* 链表中删除指定值的节点
* */
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