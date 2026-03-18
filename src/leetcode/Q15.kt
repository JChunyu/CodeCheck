package leetcode

class Q15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val results = arrayListOf<ArrayList<Int>>()
        if (nums.size < 3) return results
        nums.sort()
        // 第一个数字
        for (i in 0 until nums.size - 2) {
            // 确保不处理重复的第一个数字
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            var slow = i + 1
            var fast = nums.size - 1
            while (slow < fast) {
                // 确保处理的第二个数字不重复
                if (slow > i + 1 && nums[slow] == nums[slow - 1]) {
                    slow++
                    continue
                }
                val sum = nums[i] + nums[slow] + nums[fast]
                if (sum == 0) {
                    val sumArray = arrayListOf<Int>()
                    sumArray.add(nums[i])
                    sumArray.add(nums[slow])
                    sumArray.add(nums[fast])
                    results.add(sumArray)
                    slow++
                    fast--
                } else if (sum > 0) {
                    fast--
                } else {
                    slow++
                }
            }
            // 内部双指针，两数之和 + num[i] = 0
        }
        return results
    }
}


/*
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。
1. 找出三个数，互不相等
2. 三者之和为 0
* */