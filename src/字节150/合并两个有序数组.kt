package 字节150

import kotlin.math.min

class MergeSolution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = 0
        var j = 0
        var index = 0
        val nums3 = nums1.clone()
        while (index < nums1.size) {
            var current1 = if (i < m) {
                nums3[i]
            } else {
                Int.MAX_VALUE
            }
            var current2 = if (j < n) {
                nums2[j]

            } else {
                Int.MAX_VALUE
            }
            nums1[index] = if (current1 <= current2) {
                i++
                current1
            } else {
                j++
                current2
            }

            index++
        }
    }
}