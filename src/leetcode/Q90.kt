package leetcode

import java.util.*

fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    nums.sort()
    val res = mutableListOf<List<Int>>()
    val path = mutableListOf<Int>()
    fun dfs(start: Int) {
        res.add(path.toList())
        for (i in start until nums.size) {
            if (i > start && nums[i] == nums[i - 1]) continue
            path.add(nums[i])
            dfs(i + 1)
            path.removeAt(path.lastIndex)
        }
    }
    dfs(0)
    return res
}


fun subsetsWithDup2(nums: IntArray): List<List<Int>> {
    Arrays.sort(nums)
    val result: MutableList<List<Int>> = ArrayList()
    result.add(ArrayList())
    var size = result.size
    for (i in nums.indices) {
        val ans_tmp: MutableList<List<Int>> = ArrayList()
        for (j in result.indices) {
            // 获取上次添加的每个数组，并根据start来去掉不是上次新增的数组
            if (i > 0 && nums[i] == nums[i - 1] && j < size) {
                continue
            }
            val temp: MutableList<Int> = ArrayList()
            temp.addAll(result[j])
            temp.add(nums[i])
            ans_tmp.add(temp)
        }
        size = result.size
        result.addAll(ans_tmp)
    }
    return result
}