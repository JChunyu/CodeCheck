package 字节150

import kotlin.math.max

class RobSolution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return max(nums[0], nums[1])
        var prevprev = nums[0]
        var prev = max(nums[0], nums[1])
        var res = 0
        for (i in 2 until nums.size) {
            res = max(prev, prevprev + nums[i])
            prevprev = prev
            prev = res
        }
        return res
    }
}

//
//f(0) = nums[0]
//f(1) = max(nums[0], nums[1])
//f(i) = max(f[i - 2] + nums[i], f[i - 1])