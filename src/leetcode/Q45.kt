package leetcode

import kotlin.math.max

/*
给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

0 <= j <= nums[i]
i + j < n
返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。


假设在任意位置 x，到达 x 需要的次数是：
n = x + nums[x]
* */
class Q45 {
    fun jump(nums: IntArray): Int {
        var position = nums.size - 1
        var step = 0
        while (position > 0) {
            for (i in 0 until position) {
                // 选择最远的下标
                if (i + nums[i] >= position) {
                    position = i
                    step++
                    break
                }
            }
        }
        return step
    }
}