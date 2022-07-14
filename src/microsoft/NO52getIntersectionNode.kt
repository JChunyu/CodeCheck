package microsoft

import common.struct.ListNode

class NO52getIntersectionNode {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        val hashSet = HashSet<ListNode>()
        var nodeA = headA
        var nodeB = headB
        while (nodeA != null) {
            hashSet.add(nodeA)
            nodeA = nodeA.next
        }

        while (nodeB != null) {
            if (hashSet.contains(nodeB)) {
                return nodeB
            }
            nodeB = nodeB.next
        }
        return null
    }

    fun getIntersectionNode2(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == null || headB == null) {
            return null
        }
        var nodeA = headA
        var nodeB = headB
        while (nodeA != nodeB) {
            nodeA = if (nodeA == null) headB else nodeA.next
            nodeB = if (nodeB == null) headA else nodeB.next
        }
        return nodeA
    }
}