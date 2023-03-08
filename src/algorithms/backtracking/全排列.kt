package algorithms.backtracking

import java.util.*
import kotlin.collections.ArrayList

class Permute {

    var ans: ArrayList<List<Int>> = ArrayList()
    var temp: ArrayList<Int> = ArrayList()

    fun permute(nums: IntArray): List<List<Int>> {
        for (num in nums) {
            temp.add(num)
        }
        dfs( 0, nums.size)
        return ans
    }

    fun dfs(curLength: Int, size: Int) {
        if (curLength == size) {
            ans.add(ArrayList(temp))
        }
        for (i in curLength until size) {
            // 动态维护数组
            Collections.swap(temp, curLength, i)
            // 继续递归填下一个数
            dfs(curLength + 1, size)
            // 撤销操作
            Collections.swap(temp, curLength, i)
        }
    }

}
