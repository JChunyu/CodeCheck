package algorithms.data_structure.linked_list


class ReverseList {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null
        var point = head
        val result = ListNode(-1)
        while (point != null) {
            val next = point.next
            point.next = result.next
            result.next = point
            point = next
        }
        return result.next
    }
}