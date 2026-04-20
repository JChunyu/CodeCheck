package 字节150

class RemoveDuplicatesSolution {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return 1
        var i = 0
        var j = i + 1
        var sum = 1
        while (i < nums.size) {
            while (j < nums.size) {
                if (nums[i] == nums[j]) {
                    j++
                } else {
                    break
                }
            }
            if (j < nums.size) {
                nums[sum++] = nums[j]
            }
            i = j
        }
        return sum
    }

    fun removeDuplicates2(nums: IntArray): Int {
        val n = nums.size
        if (n < 2) return n
        var slow = 1
        var fast = 1
        while (fast < n) {
            if (nums[slow - 1] != nums[fast]) {
                nums[slow] = nums[fast]
                slow++
            }
            fast++
        }
        return slow
    }
}

fun main() {
    val res = RemoveDuplicatesSolution().removeDuplicates(intArrayOf(0,0,1,1,1,2,2,3,3,4))
    println(res)
}