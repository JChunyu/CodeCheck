package leetcode


/*
给你两个 正整数 数组 arr1 和 arr2 。

正整数的 前缀 是其 最左边 的一位或多位数字组成的整数。例如，123 是整数 12345 的前缀，而 234 不是 。

设若整数 c 是整数 a 和 b 的 公共前缀 ，那么 c 需要同时是 a 和 b 的前缀。例如，5655359 和 56554 有公共前缀 565 和 5655，而 1223 和 43456 没有 公共前缀。

你需要找出属于 arr1 的整数 x 和属于 arr2 的整数 y 组成的所有数对 (x, y) 之中最长的公共前缀的长度。

返回所有数对之中最长公共前缀的长度。如果它们之间不存在公共前缀，则返回 0 。



示例 1：

输入：arr1 = [1,10,100], arr2 = [1000]
输出：3
解释：存在 3 个数对 (arr1[i], arr2[j]) ：
- (1, 1000) 的最长公共前缀是 1 。
- (10, 1000) 的最长公共前缀是 10 。
- (100, 1000) 的最长公共前缀是 100 。
最长的公共前缀是 100 ，长度为 3 。
示例 2：

输入：arr1 = [1,2,3], arr2 = [4,4,4]
输出：0
解释：任何数对 (arr1[i], arr2[j]) 之中都不存在公共前缀，因此返回 0 。
请注意，同一个数组内元素之间的公共前缀不在考虑范围内。

提示：

1 <= arr1.length, arr2.length <= 5 * 104
1 <= arr1[i], arr2[i] <= 108

思路
首先是构建数对，会构造出 m x n个，去重复 m*n/2，再根据数组中存在相同数可以去掉一波
然后从数对中，遍历，计算前缀长度，遍历过程中不断对比选择最长的最后返回。

优化思路
1. 先对两个数组使用 hashSet 提纯，确保没有重复数字
2. 将数组从大到小排序，确保长度从最大开始
3. 如果已存在前缀长度为 n，比 n 小的数组元素可以忽略

- 能否不构建数对？

不构建全部数对的最高效解法是：用一个哈希集合（HashSet）存储第一个数组中所有数字的全部前缀，然后遍历第二个数组中的每个数字，检查该数字存在于集合中的最长前缀即可。

该解法相比两两比对的暴力解法效率高出很多，在输入数组数据量大时效果尤为明显。它通过预先处理其中一个数组的所有前缀，从而避免了大量重复比对操作。
* */
class Q3043 {
    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        val prefixes = HashSet<String>()
        for (num in arr1) {
            val s = num.toString()
            for (i in 1..s.length) {
                prefixes.add(s.substring(0, i))
            }
        }
        var maxLen = 0
        // 2. Iterate through each number in arr2.
        for (num in arr2) {
            val s = num.toString()
            for(i in s.length downTo maxLen + 1) {
                val prefix = s.substring(0, i)
                if (prefixes.contains(prefix)) {
                    maxLen = i
                    break
                }
            }
        }
        return maxLen
    }
}