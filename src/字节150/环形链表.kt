package 字节150

import common.ListNode

class HasCycleSolution {
    fun hasCycle(head: ListNode?): Boolean {
        if (head?.next == null) return false
        var slow = head
        var fast = head.next
        while (slow != fast) {
            if (fast == null || slow == null) {
                return false
            }
            slow = slow.next
            fast = fast.next
        }
        return true
    }
}