package leetcode

import common.ListNode

// -9, 3
// 5, 7
// p -9.3.

// 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
class Q21 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null && list2 == null) return null
        if (list1 == null && list2 != null) return list2
        if (list2 == null && list1 != null) return list1
        val res = ListNode(-1)
        var point = res
        var l1 = list1
        var l2 = list2
        while (l1 != null && l2 != null) {
            if (l1.`val` <= l2.`val`) {
                point.next = l1
                l1 = l1.next
            } else {
                point.next = l2
                l2 = l2.next
            }
            point = point.next!!
        }
        while (l1 != null) {
            point.next = l1
            l1 = l1.next
            point = point.next!!
        }
        while (l2 != null) {
            point.next = l2
            l2 = l2.next
            point = point.next!!
        }
        return res.next
    }
}
