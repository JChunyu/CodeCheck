package common

/*
* 双向链表
* */
data class DoubleLinkedNode(
    var value: Any?,
    var prev: DoubleLinkedNode?,
    var next: DoubleLinkedNode?
)