package leetcode

fun subsets(nums: IntArray): List<List<Int>> {
    val res = arrayListOf<List<Int>>()
    res.add(emptyList())
    for (num in nums) {
        val size = res.size
        for (i in 0 until size) {
            val newSubset = res[i].toMutableList()
            newSubset.add(num)
            res.add(newSubset)
        }
    }
    return res
}