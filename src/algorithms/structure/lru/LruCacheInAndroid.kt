package algorithms.structure.lru

import java.lang.Exception


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