package 字节150

class RemoveDuplicates2Solution {
    fun removeDuplicates(nums: IntArray): Int {
        val n = nums.size
        if (n < 2) return n
        var slow = 2
        var fast = 2
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast]
                slow++
            }
            fast++
        }
        return slow
    }
}