package algorithms.structure.lru

import java.lang.StringBuilder

class LruCacheByHashMapAndDLNode(val capacity: Int) {

    data class Entry(
        val key: Int,
        var value: Int,
        var before: Entry?,
        var after: Entry?
    )
    private var hashMap = HashMap<Int, Entry?>()

    private var head: Entry? = null
    private var tail: Entry? = null
    private var size = 0


    fun get(key: Int): Int {
        val old = hashMap[key] ?: return -1
        moveToLast(old)
        return old.value
    }


    fun put(key: Int, value: Int) {
        val old = hashMap[key]
        if (old != null) {
            old.value = value
            moveToLast(old)
        } else {
            val entry = Entry(key, value, null, null)
            hashMap.put(key, entry)
            addToLast(entry)
        }
        trimToSize()
    }

    private fun addToLast(node: Entry?) {
        if (node == null) return
        val temp = tail
        if (temp != null) {
            temp.after = node
            node.before = temp
        } else {
            head = node

        }
        tail = node
        size += 1
    }

    // b - p - a
    // b = null , head = a , a.before = null  p.before = tail  last.after = p tail = p
    private fun moveToLast(node: Entry?) {
        if (node == null) return

        var last = tail

        if (last != node) {
            val p = node
            val a = p.after
            val b = p.before
            if (b == null) {
                head = a
            } else {
                b.after = a
            }
            if (a != null) {
                a.before = b
            } else {
                last = b
            }
            if (last == null) {
                head = p
            } else {
                p.before = last
                p.after = null
                last.after = p
            }
            tail = p
        }
    }

    private fun removeHead() {
        if (head == null) return
        val temp = head?.after
        temp?.before = null
        hashMap.remove(head?.key)
        head = temp
        size -= 1
    }

    private fun trimToSize() {
        while (true) {
            if (size <= capacity) {
                break
            }
            removeHead()
        }
    }

    fun toLog(): String {
        val s = StringBuilder()
        s.append("start: ")
        while (head != null) {
            s.append("${head?.value}, ")
            head = head?.after
        }
        s.append(" / end")
        return s.toString()
    }
}

fun main() {
    val lru = LruCacheByHashMapAndDLNode(3)
    lru.apply {
        put(1, 1) // 1
        put(2, 2) // 1, 2
        get(1)    // 2, 1
        put(3, 3) // 1, 3
        get(2)    // 1, 3
        put(4, 4) // 3, 4
        get(1)    // 3, 4
        get(3)    // 4, 3
        get(4)    // 3, 4
        println(toLog())
    }
}