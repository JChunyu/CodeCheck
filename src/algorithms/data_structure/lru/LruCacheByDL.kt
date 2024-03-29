package algorithms.data_structure.lru

data class DLinkedNode(
    var key: Int = 0,
    var value: Int = 0,
    var prev: DLinkedNode? = null,
    var next: DLinkedNode? = null
)

class LruCacheByDL(private val capacity: Int) {
    private val cache: MutableMap<Int, DLinkedNode> = HashMap()
    private var size = 0
    private val head: DLinkedNode = DLinkedNode()
    private val tail: DLinkedNode = DLinkedNode()

    init {
        // 使用伪头部和伪尾部节点
        head.next = tail
        tail.prev = head
    }
    operator fun get(key: Int): Int {
        val node = cache[key] ?: return -1
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = cache[key]
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            val newNode = DLinkedNode(key, value)
            // 添加进哈希表
            cache[key] = newNode
            // 添加至双向链表的头部
            addToHead(newNode)
            ++size
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                val tail = removeTail()
                // 删除哈希表中对应的项
                cache.remove(tail!!.key)
                --size
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value
            moveToHead(node)
        }
    }

    private fun addToHead(node: DLinkedNode) {
        node.prev = head
        node.next = head.next
        head.next?.prev = node
        head.next = node
    }

    private fun removeNode(node: DLinkedNode?) {
        node?.prev?.next = node?.next
        node?.next?.prev = node?.prev
    }

    private fun moveToHead(node: DLinkedNode) {
        removeNode(node)
        addToHead(node)
    }

    private fun removeTail(): DLinkedNode? {
        val res = tail.prev
        removeNode(res)
        return res
    }
}