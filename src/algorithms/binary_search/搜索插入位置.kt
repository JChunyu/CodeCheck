package algorithms.binary_search

/*
* 二分查找，找到最终的 index ，最终多一次计算， left 会向右偏移一位，即合适的插入位置。
* */
class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val center = (right - left) / 2 + left
            when {
                nums[center] == target -> {
                    return center
                }
                target < nums[center] -> {
                    right = center - 1
                }
                else -> {
                    left = center + 1
                }
            }
        }
        return left
    }
}

fun main() {
    val r = SearchInsertPosition().searchInsert(intArrayOf(1, 3, 4, 6), 2)
    println(r)
}