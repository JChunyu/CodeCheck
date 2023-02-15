package solution.slidewindow

class NO25Exchange {
    /*
    * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
    * */
    fun exchange(nums: IntArray): IntArray {
        if (nums.isEmpty()) return nums
        var left = 0
        var right = nums.size - 1
        while (left != right) {
            if (nums[left] % 2 == 0) {
                val temp = nums[left]
                nums[left] = nums[right]
                nums[right] = temp
                right--
            } else {
                left++
            }
        }
        return nums
    }
}