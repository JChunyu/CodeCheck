package 字节150

class RemoveElementSolution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var i = 0
        var j = nums.size - 1
        var sum = 0
        while (i <= j) {
            val currentI = if (i < nums.size) {
                nums[i]
            } else {
                `val`
            }
            val currentJ = if (j >= 0) {
                nums[j]
            } else {
                `val`
            }

            if (currentI == `val`) {
                if (currentJ == `val`) {
                    j--
                } else {
                    val temp = nums[i]
                    nums[i] = currentJ
                    nums[j] = temp
                    sum++
                    i++
                }
            } else {
                sum++
                i++
            }
        }
        return sum
    }
}

fun main() {
    val intArray = intArrayOf(3,2,2,3)
    val res = RemoveElementSolution().removeElement(intArray, 3)
    println("res = $res")
}