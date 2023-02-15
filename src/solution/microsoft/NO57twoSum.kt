package solution.microsoft

class NO57twoSum {
    // 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            val less = target - nums[i]
            if (less > nums[i]) {
                var j = i + 1
                while (j < nums.size) {
                    if (nums[j] + nums[i] == target) {
                        return intArrayOf(nums[i], nums[j])
                    }
                    j++
                }
            }
        }
        return intArrayOf()
    }

    fun twoSum2(nums: IntArray, target: Int): IntArray {
        var i = 0
        var j = nums.size - 1
        while (i < j) {
            val sum = nums[i] + nums[j]
            if (target == sum) {
                return intArrayOf(nums[i], nums[j])
            } else if (target < sum) {
                j--
            } else if (target > sum) {
                i++
            }
        }
        return intArrayOf()
    }
}