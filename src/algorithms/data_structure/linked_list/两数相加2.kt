package algorithms.data_structure.linked_list

class AddTwoNumbers2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var link1 = l1
        var link2 = l2
        var attach = 0

        var rv1: ListNode? = null
        var rv2: ListNode? = null
        var answer: ListNode? = null
        // 反转链表
        while (link1 != null) {
            val temp = rv1
            rv1 = link1
            link1 = link1.next
            rv1.next = temp
        }
        while (link2 != null) {
            val temp = rv2
            rv2 = link2
            link2 = link2.next
            rv2.next = temp
        }
        // 开始计算
        while (rv1 != null || rv2 != null) {
            val res = (rv1?.`val` ?: 0) +( rv2?.`val` ?: 0) + attach
            attach = if (res >= 10) {
                1
            } else {
                0
            }
            val cur = res % 10
            val temp = answer
            answer = ListNode(cur)
            answer.next = temp
            if (rv1 != null) {
                rv1 = rv1.next
            }
            if (rv2 != null) {
                rv2 = rv2.next
            }
        }
        // 最高位额外进位处理
        if (attach != 0) {
            val temp = answer
            answer = ListNode(attach)
            answer.next = temp
        }
        return answer
    }
}

fun main() {
    val l1 = ListNode(1)
    val l2 = ListNode(9)
    val l3 = ListNode(3)
    val l4 = ListNode(4)
    val l5 = ListNode(5)
    val l6 = ListNode(6)

    l1.next = l2
    l2.next = l3
    l4.next = l5
    l5.next = l6

    AddTwoNumbers2().addTwoNumbers(l1, l4)
}