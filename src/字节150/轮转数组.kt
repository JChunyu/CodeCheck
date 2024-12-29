package 字节150

class RotateSolution {
    fun rotate(nums: IntArray, k: Int): Unit {
        if (nums.size < 2) return
        var x = if (k > nums.size) {
            k % nums.size
        } else {
            k
        }
        var fast = nums.size - x
        var slow = nums.size - x - 1
        var tempArray = IntArray(x) { 0 }
        var tempIndex = 0
        while (fast < nums.size) {
            tempArray[tempIndex] = nums[fast]
            fast++
            tempIndex++
        }
        while (slow >= 0) {
            nums[slow + x] = nums[slow]
            slow--
        }
        var index = 0
        while (index < x) {
            nums[index] = tempArray[index]
            index++
        }
    }
}