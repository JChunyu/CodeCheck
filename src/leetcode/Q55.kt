package leetcode

import kotlin.math.max

/*
给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。


* */
class Q55 {
    fun canJump(nums: IntArray): Boolean {
        val lastIndex = nums.size - 1
        // 最远到达位置
        var mostIndex = 0
        for (i in 0 until nums.size) {
            if (i <= mostIndex) {
                mostIndex = Math.max(mostIndex, i + nums[i])
                if (mostIndex >= lastIndex) {
                    return true
                }
            }
        }
        return false
    }
}