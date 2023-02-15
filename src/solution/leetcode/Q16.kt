package solution.leetcode

import kotlin.math.abs

/*
* 最接近的三数之和
* https://leetcode.cn/problems/3sum-closest/
*
* 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使 *它们的和* 与 target 最接近。
* 返回这三个数的和。
* 假定每组输入只存在恰好一个解。
*
* note：
* 3 <= nums.length <= 1000
* -1000 <= nums[i] <= 1000
* -104 <= target <= 104
*
* 容易理解错成，target 最近的三个数之和
* */
class Q16 {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var res = Int.MAX_VALUE
        nums.sort()
        for (i in nums.indices) {
            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                if (sum == target) return sum
                if (abs(sum - target) < abs(res - target)) {
                    res = sum
                }
                if (sum > target) {
                    right--
                    while (left < right && nums[right] == nums[right + 1]) right--
                } else {
                    left++
                    while (left < right && nums[left] == nums[left - 1]) left++
                }
            }
        }
        return res
    }
}

fun main() {

//    val res = Q16().threeSumClosest(intArrayOf(4,0,5,-5,3,3,0,-4,-5), -2)
    val res = Q16().threeSumClosest(intArrayOf(0, 0, 0), 1)
//    val res = Q16().threeSumClosest(
//        intArrayOf(321,413,82,812,-646,-858,729,609,-339,483,-323,-399,-82,-455,18,661,890,-328,-311,520,-865,-174,55,685,-636,462,-172,-696,-296,-832,766,-808,-763,853,482,411,703,655,-793,-121,-726,105,-966,-471,612,551,-257,836,-94,-213,511,317,-293,279,-571,242,-519,386,-670,-806,-612,-433,-481,794,712,378,-325,-564,477,169,601,971,-300,-431,-152,285,-899,978,-419,708,536,-816,-335,284,384,-922,-941,633,934,497,-351,62,392,-493,-44,-400,646,-912,-864,835,713,-12,322,-228,340,-42,-307,-580,-802,-914,-142,575,-684,-415,718,-579,759,579,732,-645,525,114,-880,-603,-699,-101,-738,-887,327,192,747,-614,393,97,-569,160,782,-69,235,-598,-116,928,-805,-76,-521,671,417,600,-442,236,831,637,-562,613,-705,-158,-237,-299,808,-734,364,919,251,-163,-343,899),
//        2218)
//    val res = Q16().threeSumClosest(intArrayOf(-1,2,1,-4), 1)
    println(res)
}