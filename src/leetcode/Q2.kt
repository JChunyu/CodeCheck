package leetcode

import common.ListNode


/*
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
* */



class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) return null
        if (l1 == null) return l2
        if (l2 == null) return l1
        var enter = 0
        var res = ListNode(-1)
        var point1 = l1
        var point2 = l2
        var pointR: ListNode? = res
        while (point1 != null || point2 != null) {
            var current1 = point1?.`val` ?: 0
            var current2 = point2?.`val` ?: 0
            var sum = current1 + current2 + enter
            var currentR = if (sum > 9) {
                enter = 1
                sum % 10
            } else {
                enter = 0
                sum
            }
            val node = ListNode(currentR)
            pointR?.next = node
            pointR = pointR?.next
            point1 = point1?.next
            point2 = point2?.next
        }
        if (enter == 1) {
            val node = ListNode(enter)
            pointR?.next = node
            pointR = pointR?.next
        }
        return res.next
    }
}