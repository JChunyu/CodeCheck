package leetcode

fun sortedSquares(nums: IntArray): IntArray {
    val absNums = nums.map {
        if (it < 0) {
            -it
        } else {
            it
        }
    }
    val new = absNums.sorted()
    return new.map { it * it }.toIntArray()
}