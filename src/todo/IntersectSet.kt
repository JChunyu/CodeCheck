package todo

class IntersectSet {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        if (nums1.isEmpty() || nums2.isEmpty()) {
            return intArrayOf()
        }
        val hashMap = HashMap<Int, Int>()
        val hashMap2 = HashMap<Int, Int>()
        val minArray: IntArray
        val anotherArray: IntArray
        if (nums1.size <= nums2.size) {
            minArray = nums1
            anotherArray = nums2
        } else {
            minArray = nums2
            anotherArray = nums1
        }

        minArray.forEach {
            if (anotherArray.contains(it)) {
                val num = if (hashMap.containsKey(it)) {
                    hashMap[it] ?:  0
                } else {
                    0
                }
                hashMap[it] = num + 1
            }
        }

        anotherArray.forEach {
            if (hashMap.containsKey(it)) {
                val num = if (hashMap2.containsKey(it)) {
                    hashMap2[it] ?: 0
                } else {
                    0
                }
                hashMap2[it] = num + 1
            }
        }

        hashMap.keys.forEach {
            if (hashMap2.containsKey(it)) {
                if (hashMap[it] != null && hashMap2[it] != null) {
                    hashMap[it] = if (hashMap[it]!! < hashMap2[it]!!) hashMap[it]!! else hashMap2[it]!!
                }
            }
        }

        val result = arrayListOf<Int>()

        hashMap.forEach { (key, value) ->
            for (i in 0 until value) {
                result.add(key)
            }
        }
        return result.toIntArray()
    }
}