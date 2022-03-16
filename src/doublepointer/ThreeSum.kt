package doublepointer

/*
* 三数之和
* 标签：数组遍历
*
* 知识点：通过双指针减少循环次数。且双指针场景一般使用 while 语句而不是 for 嵌套。
* */
class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val ans: ArrayList<List<Int>> = ArrayList()
        nums.sort()
        if (nums.size < 3) return ans
        for (first in nums.indices) {
            // 若首位数大于 0 ，一定没有为 0 的和。
            if (nums[first] > 0) return ans
            // 相同数字直接下一个
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue
            }
            // 从排好序的数组的最大和最小值开始，能够有效减少循环次数
            var left = first + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[first] + nums[left] + nums[right]
                if (sum == 0) {
                    ans.add(listOf(nums[first],  nums[left], nums[right]))
                    // 相同数字直接下一个
                    while (left < right && nums[left] == nums[left + 1]) left++
                    while (left < right && nums[right] == nums[right - 1]) right--
                    left++
                    right--
                } else if (sum < 0) {
                    // 当前和小于0，左指针需要向右移动
                    left++
                } else if (sum > 0) {
                    // 当前和大于0，右指针需要向左移动
                    right--
                }
            }
        }
        return ans
    }
}

fun main() {
    val list = intArrayOf(-1,0,1,2,-1,-4)
    ThreeSum().threeSum(list)
}