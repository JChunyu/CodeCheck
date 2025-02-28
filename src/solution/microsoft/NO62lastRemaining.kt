package solution.microsoft

import common.ListNode


class NO62lastRemaining {

    fun lastRemaining2(n: Int, m: Int): Int {
        val list = ArrayList<Int>()
        for (i in 0 until n) {
            list.add(i)
        }

        var length = n
        var index = 0

        while (length > 1) {
            index = (index + m - 1) % length
            list.removeAt(index)
            length--
        }
        return list.first()
    }

    // 环。数量大时，会超出时间限制，但思路清晰
    fun lastRemaining(n: Int, m: Int): Int {

        var prev: ListNode? = ListNode(-1)
        var point: ListNode? = prev
        //构建环
        for (i in 0 until n) {
            val current = ListNode(i)
            prev?.next = current
            prev = prev?.next
        }
        prev?.next = point?.next
        // 此时 prev = last，point.next = first

        // 开始循环删除
        while (prev?.next != prev) {
            var temp = m
            while (temp > 1) {
                prev = prev?.next
                temp--
            }
            prev?.next = prev?.next?.next
            point = prev?.next
        }
        return point?.`val` ?: 0
    }
}

fun main() {
    val no62 = NO62lastRemaining().lastRemaining(5, 3)
    print(no62)
}