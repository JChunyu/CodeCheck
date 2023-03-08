package algorithms.backtracking


class Combine {
    var temp: ArrayList<Int> = ArrayList()
    var ans: ArrayList<List<Int>> = ArrayList()

    fun combine(n: Int, k: Int): List<List<Int>>? {
        dfs(1, n, k)
        return ans
    }

    fun dfs(cur: Int, n: Int, k: Int) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size + (n - cur + 1) < k) {
            return
        }
        // 记录合法的答案
        if (temp.size == k) {
            ans.add(ArrayList<Int>(temp))
            return
        }
        // 考虑选择当前位置
        temp.add(cur)
        dfs(cur + 1, n, k)
        temp.removeAt(temp.size - 1)

        // 考虑不选择当前位置
        dfs(cur + 1, n, k)
    }
}