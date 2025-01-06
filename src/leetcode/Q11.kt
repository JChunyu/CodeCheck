package leetcode

import kotlin.math.max
import kotlin.math.min

class Q11 {
    fun maxArea2(height: IntArray): Int {
        if (height.size < 2) return 0
        var maxEntry = 0
        for (i in 0 until height.size - 1) {
            for (j in i + 1 until height.size) {
                val curr = min(height[i], height[j]) * (j - i)
                maxEntry = max(maxEntry, curr)
            }
        }
        return maxEntry
    }

    fun maxArea(height: IntArray): Int {
        if (height.size < 2) return 0
        var maxEntry = 0
        var slow = 0
        var fast = height.size - 1
        while (slow < fast) {
            val curWidth = fast - slow
            val curHeight = min(height[slow], height[fast])
            val curr = curWidth * curHeight
            maxEntry = max(maxEntry, curr)
            if (height[slow] < height[fast]) {
                slow++
            } else {
                fast--
            }
        }
        return maxEntry
    }
}

/*
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器。

1,8,6,2,5,4,8,3,7
49

if (n > max(height[i]))
slow .. fast

2,3,4,5,18,17,6

(fast - slow) * min(height[fast], height[slow])
* */