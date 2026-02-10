package leetcode

fun removeElement(nums: IntArray, value: Int): Int {
    var count = 0

    for (i in nums.indices) {
        if (nums[i] != value) {
            nums[count++] = nums[i];
        }
    }

    nums.forEach {
        print("${it}、")
    }
    print("\n")
    print(count)
    return count
}