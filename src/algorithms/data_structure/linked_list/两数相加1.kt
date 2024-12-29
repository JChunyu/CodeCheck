package algorithms.data_structure.linked_list

class AddTwoNumbers1 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var link1 = l1
        var link2 = l2
        var attach = 0
        val answer = ListNode(-1)
        var head: ListNode? = answer

        // 开始计算
        while (link1 != null || link2 != null) {
            val res = (link1?.`val` ?: 0) +( link2?.`val` ?: 0) + attach
            attach = if (res >= 10) {
                1
            } else {
                0
            }
            val cur = res % 10
            head?.next = ListNode(cur)
            head = head?.next
            if (link1 != null) {
                link1 = link1.next
            }
            if (link2 != null) {
                link2 = link2.next
            }
        }
        // 最高位额外进位处理
        if (attach != 0) {
            head?.next = ListNode(attach)
        }
        return answer.next
    }
}