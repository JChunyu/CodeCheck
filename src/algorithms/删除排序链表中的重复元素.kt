package algorithms

import common.ListNode

class DeleteDuplicatesSolution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) return null
        var point = head
        while (point?.next != null) {
            if (point.value == point.next?.value) {
                point.next = point.next?.next
            } else {
                point = point.next!!
            }
        }
        return head
    }
}