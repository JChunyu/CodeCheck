package algorithms.two_point


/*
* 167 两数之和-输入有序数组
* - 下标从 1 开始的整数数组 numbers，已按 非递减 顺序排列 （意思是：递增序排列，但是并非单调递增（因为有重复的元素））
* - 从数组中找出相加之和等于target的两个数，以数组的形式返回两数的index。
* - 假设每个输入只对应一个标准答案，而且不可以重复使用相同的元素。
* - 解决方案必须只使用常量级的额外空间。：常数级别的额外空间就是O(1)，即要求空间复杂度是 O(1)，即算法所消耗的内存空间 **不随被处理数据量 变化、或递归深度增减而改变。**
*
* 思路
* - 双指针1，暴力解法
*   - 直接两个for循环嵌套，时间复杂度O(n的平方)
* - 根据 target 分析不同的情况
*   1. target <= numbers[0]，不存在答案
*   2. target > numbers[size - 1],
*      1. 优先选择 size - 1 位置的元素，然后左边取 index = 0 的元素，依次向右递增。直到 两数之和 = target 或 left = right。  （终止条件 sum == target 和 left >= right），
*         另外，若 两数之和 > target, 则可以终止
*      2. 若size - 1遍历完仍没有能够等于target的答案，则right向左移动一位，然后继续执行第一步. right向左移动的终止条件是 right <= 1
*
*   3. target > numbers[0] && target < numbers[size - 1]
*      这种情况可以先找出numbers中与target最接近，并且小于target的元素的index，然后采用情况2的步骤即可。
* */
class TwoNumberSum2 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        if (target > numbers[numbers.size - 1] && target < numbers[0]) return IntArray(2)
        var left = 0
        var right = numbers.size - 1
        while (left < right) {
            val sum = numbers[left] + numbers[right]
            if (target > sum) {
                left++
                continue
            }
            if (target < sum) {
                right--
                continue
            }
            if (target == sum) {
                return intArrayOf(left + 1, right + 1)
            }
        }
        return IntArray(2)
    }
}