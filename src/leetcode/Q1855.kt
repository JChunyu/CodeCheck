package leetcode

/*
* 一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。（意思是数组是递减或者相等的）
* 给你两个 非递增 的整数数组 nums1 和 nums2 ，数组下标均 从 0 开始 计数。
* 下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。
*
* 如果该下标对同时满足 i <= j 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为 j - i。
* 返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。
* */
class Q1855 {
    fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
        if (nums1.isEmpty() || nums2.isEmpty()) return 0
        var j = nums2.lastIndex
        var max = 0
        // 实际上的索引有效范围是 0 - j
        while (j > 0) {
            var i = 0
            while (i < j && i <= nums1.lastIndex) {
                if (nums1[i] <= nums2[j]) {
                    max = maxOf(max, j - i)
                    break
                } else {
                    i++
                }
            }
            j--
        }
        return max
    }
}
fun main() {
    val q = Q1855()
    println(q.maxDistance(intArrayOf(30,29,19,5), intArrayOf(25,25,25,25,25)))
}