package 字节150

class MajorityElementSolution {
    fun majorityElement(nums: IntArray): Int {
        val hashMap = hashMapOf<Int, Int>()
        var maxNum = 0
        var res = 0
        nums.forEach {
            val old = hashMap[it] ?: 0
            hashMap[it] = old + 1
            if (hashMap[it]!! > maxNum) {
                res = it
            }
        }
        return res
    }
}