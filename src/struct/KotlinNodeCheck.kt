package struct

/*
* 通过一个 temp 复制一份构造参数中的 node
* 然后在用 prev 复制一份 temp
* prev 增删操作，实际上是 temp 上的内容
*
* */
class KotlinNodeCheck {
    fun checkNode(node: ListNode?, n: Int) {
        var temp = node
        println("---------prev----------")
        var prev = temp
        for (i in 0 until n) {
            prev = prev?.next
        }
        prev?.next = prev?.next?.next

        while (prev != null) {
            println(prev.`val`)
            prev = prev.next
        }
        println("---------temp----------")
        while (temp != null) {
            println(temp.`val`)
            temp = temp.next
        }
    }
}