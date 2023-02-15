package solution.doublepointer


/*
* 思路：
* - 对于同一个列表，顺序遍历，检查每个元素是否 = 0
* - 用另一个index记录非0元素的位置
* - 当元素非0时，将元素存到当前数组的index位置中，然后index + 1，同时，如果 index 不等于当前遍历的位置i，则将当前位置 i 存放 0
* - 当元素为0时，继续遍历下一个元素
* */
class MoveZero {
    fun moveZeroes(nums: IntArray): Unit {
        var index = 0
        nums.forEachIndexed { i, value ->
            if (value != 0) {
                nums[index] = value
                if (i != index) {
                    nums[i] = 0
                }
                index++
            }
        }
    }
}
