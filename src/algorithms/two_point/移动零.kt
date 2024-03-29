package algorithms.two_point

/*
* 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
* 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
* */
class MoveZeros {
    fun moveZeroes(nums: IntArray) {
        var index = 0
        var zeroNum = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                nums[index++] = nums[i]
            } else {
                zeroNum++
            }
        }
        for (i in zeroNum downTo 1) {
            nums[index++] = 0
        }
    }
}

/*
* 思路：
* - 对于同一个列表，顺序遍历，检查每个元素是否 = 0
* - 用另一个index记录非0元素的位置
* - 当元素非0时，将元素存到当前数组的index位置中，然后index + 1，同时，如果 index 不等于当前遍历的位置i，则将当前位置 i 存放 0
* - 当元素为0时，继续遍历下一个元素
* */
class MoveZero2 {
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


fun main() {
    val nums = intArrayOf(0, 1)
    val n = MoveZeros().moveZeroes(nums)
    nums.forEach {
        println(it)
    }
}