package leetcode

class Q238 {

    /*
给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。

题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
    * */

    // o n2
    fun productExceptSelf2(nums: IntArray): IntArray {
        val answer = IntArray(nums.size)
        for (i in nums.indices) {
            var cur = 1
            for (j in nums.indices) {
                if (j == i) continue
                cur *= nums[j]
            }
            answer[i] = cur
        }
        return answer
    }

    // o n
    fun productExceptSelf(nums: IntArray): IntArray {
        if (nums.size == 1) return intArrayOf(0)
        val answer = IntArray(nums.size)
        val temp = IntArray(nums.size)
        val reverse = IntArray(nums.size)
        // front
        var total = 1
        for (i in nums.indices) {
            total *= nums[i]
            temp[i] = total
        }
        // tail
        var reveseTotal = 1
        for (i in nums.size - 1 downTo 0) {
            reveseTotal *= nums[i]
            reverse[i] = reveseTotal
        }

        answer[0] = reverse[1]
        answer[nums.size - 1] = temp[nums.size - 2]
        for (i in 1 until nums.size - 1) {
            answer[i] = temp[i - 1] * reverse[i + 1]
        }
        return answer
    }
}