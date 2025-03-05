package algorithms

import common.ListNode


class ListNodeProj {
    /*
    * Q21: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    * 知识点：需要用一个节点作为起始位置标记，如果一个为空，后续不需要在继续遍历直接链接提高效率
    * */
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1
        val resCursor = ListNode(-1)
        var cursor: ListNode? = resCursor
        var l1Cursor = list1
        var l2Cursor = list2

        while (l1Cursor != null && l2Cursor != null) {
            if (l1Cursor.`val` <= l2Cursor.`val`) {
                cursor?.next = l1Cursor
                l1Cursor = l1Cursor.next
            } else {
                cursor?.next = l2Cursor
                l2Cursor = l2Cursor.next
            }
            cursor = cursor?.next
        }
        if (l1Cursor == null) {
            cursor?.next = l2Cursor
        }
        if (l2Cursor == null) {
            cursor?.next = l1Cursor
        }
        return resCursor.next
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
            if (a.`val` < b.`val`) {
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
            if (n1.`val` >= n2.`val`) {
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


    /*
    * 19. 删除链表的倒数第 N 个结点
    * 需要用一个索引节点来记录变更后的结果；删除单向链表中的元素要用待删除的节点的前一个的引用
    * */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) return null
        val res = ListNode(-1)
        var cursor1: ListNode? = res
        cursor1?.next = head
        var cursor2: ListNode? = head
        for (i in 1..n) {
            cursor2 = cursor2?.next
        }
        while (cursor2 != null) {
            cursor1 = cursor1?.next
            cursor2 = cursor2.next
        }
        cursor1?.next = cursor1?.next?.next
        return res.next
    }


    /*
    * 23. 合并 K 个升序链表
    * 思路是
    * 1. 第一个和第二个合并，然后结果再合并第三个，这样一直合并到最后一个，借助合并两个链表来实现
    * 2. 每一轮两两合并，log 指数次合并后为单一链表
    * */
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        var merged = lists.first()
        var i = 1
        while (i < lists.size) {
            merged = mergeTwoLists(merged, lists[i])
            i++
        }
        return merged
    }

    /*
    * 24. 两两交换链表中的节点
    * */
    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null) return null
        if (head.next == null) return head
        val ans = ListNode(-1)
        var prevCursor: ListNode? = ans
        var cursor1 = head
        var cursor2 = head
        // 快指针先移动一步
        cursor2 = cursor2.next

        while (cursor2 != null) {
            // current
            // cursor1 = head
            // cursor2 = head.next

            // swap
            val temp = cursor2.next
            prevCursor?.next = cursor2
            cursor2.next = cursor1
            cursor1?.next = temp

            // all cursor
            prevCursor = cursor1
            cursor2 = cursor1?.next?.next
            cursor1 = cursor1?.next
        }

        return ans.next
    }

    /*
    * 25. K 个一组翻转链表
    * 解题思路，首先要写一个翻转 K 个节点的链表操作
    * */
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null) return null

        val ans = ListNode(-1)
        var ansCursor: ListNode? = ans

        var i = 1
        var headCursor: ListNode? = head

        var checkLengthCursor: ListNode? = headCursor

        while (checkLengthCursor != null) {
            // 遍历到第 K 个节点
            if (i == k) {
                // 保存当前节点为子链表的尾部
                val tail = checkLengthCursor
                // 下一个子列表的头部
                val next = checkLengthCursor.next
                // 截断
                tail.next = null
                // 反转 K 个
                val reversed = reverse(headCursor)
                ansCursor?.next = reversed
                // 移动结果光标到最后一个
                while (ansCursor?.next != null) {
                    ansCursor = ansCursor.next
                }
                headCursor = next
                checkLengthCursor = next // 下一个列表开始
                i = 1
            } else {
                checkLengthCursor = checkLengthCursor.next
                i++
            }
        }
        if (headCursor != null) {
            ansCursor?.next = headCursor
        }
        return ans.next
    }

    // 反转链表
    private fun reverse(head: ListNode?): ListNode? {
        if (head == null) return null
        val ans = ListNode(-1)
        var cursor: ListNode? = head

        while (cursor != null) {
            val tempNewStack = ans.next
            val temp = cursor.next
            ans.next = cursor
            cursor.next = tempNewStack
            cursor = temp
        }
        return ans.next
    }

    /*
    * 61. 旋转链表
    * */
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null) return null
        if (k == 0) return head

        var cursor1: ListNode? = head
        var cursor2: ListNode? = head
        var length = 1

        while (cursor2?.next != null) {
            length++
            cursor2 = cursor2.next
        }
        // 此时 cursor1 = head cursor2 = tail
        // 形成一个环
        cursor2?.next = cursor1

        var i = length - (k % length)

        while (i > 0) {
            cursor1 = cursor1?.next
            cursor2 = cursor2?.next
            i--
        }

        val newHead = cursor1
        cursor2?.next = null

        return newHead
    }


    /*
    * 82. 删除排序链表中的重复元素 II
    * */
    fun deleteDuplicates2(head: ListNode?): ListNode? {
        if (head == null) return null
        val ans = ListNode(-1)
        ans.next = head
        var prev: ListNode? = ans
        var cursor1: ListNode? = head
        var cursor2: ListNode? = head
        // 先走一步，确保一前一后
        cursor2 = cursor2?.next

        while (cursor2 != null) {
            var needDrop = false
            while (cursor1?.`val` == cursor2?.`val`) {
                needDrop = true
                cursor2 = cursor2?.next
                cursor1?.next = cursor2
            }

            cursor2 = cursor2?.next
            cursor1 = cursor1?.next
            if (needDrop) {
                prev?.next = cursor1
            } else {
                prev = prev?.next
            }
        }
        return ans.next
    }

    /*
    * 83. 删除排序链表中的重复元素
    * */
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) return null
        var cursor1: ListNode? = head
        var cursor2: ListNode? = head
        cursor2 = cursor2?.next
        while (cursor2 != null) {
            while (cursor1?.`val` == cursor2?.`val`) {
                cursor2 = cursor2?.next
                cursor1?.next = cursor2
            }
            cursor2 = cursor2?.next
            cursor1 = cursor1?.next
        }
        return head
    }

    /*
    * 86. 分隔链表
    * 需要注意不能直接操作 cursor, 要保存当前 cursor，然后先 cursor = cursor.next， 如果直接引用  x = cursor, x.next = null 会导致 cursor.next = null
    * */
    fun partition(head: ListNode?, x: Int): ListNode? {
        if (head == null) return null
        val before = ListNode(-1)
        val after = ListNode(-1)
        var beforeLastCursor: ListNode? = before
        var afterLastCursor: ListNode? = after

        var cursor: ListNode? = head

        while (cursor != null) {
            val temp = cursor
            cursor = cursor.next
            if (temp.`val` < x) {
                beforeLastCursor?.next = temp
                beforeLastCursor = beforeLastCursor?.next
                beforeLastCursor?.next = null
            } else {
                afterLastCursor?.next = temp
                afterLastCursor = afterLastCursor?.next
                afterLastCursor?.next = null
            }
        }
        beforeLastCursor?.next = after.next
        return before.next
    }

    /*
    * 92. 反转链表 II
    * 需要注意不能直接返回 head，需要用一个 ans 假节点，因为 head 内部的节点有断裂操作
    * */
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (head == null) return null
        if (right <= left) {
            return head
        }
        val ans = ListNode(-1)
        var prev: ListNode? = ans
        prev?.next = head
        var curr: ListNode? = head

        var reverse: ListNode? = ListNode(-1)
        var reverseLast: ListNode? = null

        var i = 1
        while (i < left) {
            curr = curr?.next
            prev = prev?.next
            i++
        }
        for (i in left..right) {
            val temp = curr
            curr = curr?.next

            temp?.next = null
            if (reverse?.next == null) {
                reverseLast = temp
            }
            val reverseNext = reverse?.next
            temp?.next = reverseNext
            reverse?.next = temp
        }
        prev?.next = reverse?.next
        reverseLast?.next = curr
        // 左侧的再走
        return ans.next
    }
}

fun main() {
//    val n1 = ListNode(1)
//    val n2 = ListNode(2)
//    val n3 = ListNode(4)
//    val m1 = ListNode(1)
//    val m2 = ListNode(3)
//    val m3 = ListNode(4)
//
//    n1.next = n2
//    n2.next = n3
//
//    m1.next = m2
//    m2.next = m3
//
    val listNodeProj = ListNodeProj()
//
//    var node = listNodeProj.mergeTwoLists(n1, m1)
//    while (node != null) {
//        println(node.`val`)
//        node = node.next
//    }


    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)


    node1.next = node2
//    node2.next = node3
//    node3.next = node4
//    node4.next = node5
//    node5.next = null

    var res = listNodeProj.reverseBetween(node1, 1, 2)
    while (res != null) {
        println(res.`val`)
        res = res.next
    }
}

