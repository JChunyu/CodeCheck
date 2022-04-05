package microsoft.dynamicprogramming

import kotlin.math.max

class MaxSubArray {
    /*
    * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
    * f x = max(f (x - 1) + nums[i], nums[i])
    * */
    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var pre = 0
        var maxAns = nums[0]
        nums.forEach {
            pre = Math.max(pre +it, it)
            maxAns = Math.max(maxAns, pre)
        }
        return maxAns
    }
}