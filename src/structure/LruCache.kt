package structure

import java.lang.Exception
import java.lang.StringBuilder

/*
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
* */

fun main() {
    val lru = LRUCache(3)
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

class LRUCache(val capacity: Int) {

    data class Entry(
        val key: Int,
        var value: Int,
        var before: Entry?,
        var after: Entry?
    ) {
        override fun toString(): String {
            return "key: $key, value: $value, before: ${before?.key}, after: ${after?.key}"
        }
    }

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

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */


/*
* LinkedHashMap 实现，需要Android 特定版本LinkedHashMap
* */
open class LruCache<K, V>(private var maxSize: Int) {

    private val map = LinkedHashMap<K, V>(0, 0.75f, true)

    private var size: Int = 0

    fun get(key: K): V? {
        return map.get(key)
    }

    fun put(key: K, value: V) {
        var old: V? = null
        old = map.put(key, value)
        size += sizeOf(key, value)
        if (old != null) {
            size -= sizeOf(key, old)
        }
        trimToSize(maxSize)
    }

    // 默认 1 ，供子类实现
    open fun sizeOf(key: K, value: V): Int {
        return 1
    }

    private fun trimToSize(max: Int) {
        while (true) {
            var k: K?
            var v: V?
            if (size < 0 || (map.isEmpty() && size != 0)) {
                throw Exception("error")
            }
            if (size <= max) {
                break
            }

            // android 特供
//            val eldest: Map.Entry<K, V>? = map.eldest()
//            if (eldest == null) {
//                break
//            }
//            k = eldest.key
//            v = eldest.value
//            map.remove(k)
//            size -= sizeOf(k, v)
        }
    }
}