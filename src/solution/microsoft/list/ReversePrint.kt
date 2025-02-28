package solution.microsoft.list

import common.ListNode

/*
* 单纯链表遍历时，while 判断条件为 solution.node != null 而不是 solution.node.next != null
* 链表删除操作
* 1. 记录下 next 为 temp
* 2. current 指向该指的内容 （可以时删除，也可以时倒序）
* 3. current = temp 指向下一个节点
* */
class ReversePrint {
    fun reversePrint(head: ListNode?): IntArray {
        var cur = head
        var reverse: ListNode? = null
        var length = 0
        // 反转
        while (cur != null) {
            val temp = cur.next
            cur.next = reverse
            reverse = cur
            cur = temp
            length++
        }
        val intArray = IntArray(length)

        var i = 0
        while (reverse != null) {
            intArray[i] = reverse.`val`
            reverse = reverse.next
            i++
        }
        return intArray
    }
}

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    var a = ReversePrint().reversePrint(node1)
}