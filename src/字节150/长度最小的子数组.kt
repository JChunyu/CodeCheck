package 字节150

import kotlin.math.min

class MinSubArrayLenSolution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var count = Int.MAX_VALUE
        var start = 0
        var end = 0
        var sum = 0

        while (end < nums.size) {
            sum += nums[end]
            while (sum >= target) {
                count = min(count, end - start + 1)
                sum -= nums[start]
                start++
            }
            end++
        }
        return if (count == Int.MAX_VALUE) 0 else count
    }
}