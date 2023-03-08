package algorithms.data_structure.linked_list

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class MergeTwoLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1
        val head = ListNode(-1)
        var point: ListNode? = head
        var l1 = list1
        var l2 = list2
        while (l1 != null && l2 != null) {
            if (l1.`val` <= l2.`val`) {
                point?.next = l1
                l1 = l1.next

            } else {
                point?.next = l2
                l2 = l2.next
            }
            point = point?.next
        }
        if (l1 != null) {
            point?.next = l1
        }

        if (l2 != null) {
            point?.next = l2
        }
        return head.next
    }


    fun mergeTwoLists2(l1: common.ListNode?, l2: common.ListNode?): common.ListNode? {
        if (l1 == null && l2 == null) return null
        if (l1 == null && l2 != null) return l2
        if (l1 != null && l2 == null) return l1
        val res = common.ListNode(-1)
        var head: common.ListNode
        var a = l1
        var b = l2
        res.next = a
        while (a != null && b != null) {
            if (a.value < b.value) {
                head = a
                a = a.next
            } else {
                res.next = b
                b = b.next
            }
        }
        return res.next
    }

    fun mergeTwoLists3(l1: common.ListNode?, l2: common.ListNode?): common.ListNode? {
        val node = common.ListNode(-1)
        var current: common.ListNode? = node
        var n1 = l1
        var n2 = l2
        var last: common.ListNode? = null

        while (n1 != null && n2 != null) {
            if (n1.value >= n2.value) {
                current?.next = n2
                n2 = n2.next
            } else {
                current?.next = n1
                n1 = n1.next
            }
            current = current?.next
        }
        if (n1 != null) {
            last = n1
        }
        if (n2 != null) {
            last = n2
        }
        current?.next = last
        return node.next
    }
}

fun main() {
    val n1 = ListNode(1)
    val n2 = ListNode(2)
    val n3 = ListNode(4)
    val m1 = ListNode(1)
    val m2 = ListNode(3)
    val m3 = ListNode(4)

    n1.next = n2
    n2.next = n3

    m1.next = m2
    m2.next = m3

    var node = MergeTwoLists().mergeTwoLists(n1, m1)
    while (node != null) {
        println(node.`val`)
        node = node.next
    }

}