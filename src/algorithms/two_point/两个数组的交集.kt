package algorithms.two_point

import java.sql.Array
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class Intersection {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val hashSet = HashSet<Int>()
        val res = ArrayList<Int>()
        nums1.forEach { hashSet.add(it) }
        nums2.forEach {
            if (hashSet.contains(it)) {
                hashSet.remove(it)
                res.add(it)
            }
        }
        return res.toIntArray()
    }

    fun intersection2(nums1: IntArray, nums2: IntArray): IntArray {
        Arrays.sort(nums1)
        Arrays.sort(nums2)
        var length1 = nums1.size
        var length2 = nums2.size
        var res = IntArray(length1 + length2)
        var index = 0
        var index1 = 0
        var index2 = 0
        while (index1 < length1 && index2 < length2) {
            val n1 = nums1[index1]
            val n2 = nums2[index2]
            if (n1 == n2) {
                if (index == 0 || n1 != res[index - 1]) {
                    res[index++] = n1
                }
                index1++
                index2++
            } else if (n1 < n2) {
                index1++
            } else {
                index2++
            }
        }
        return Arrays.copyOfRange(res, 0, index)
    }
}