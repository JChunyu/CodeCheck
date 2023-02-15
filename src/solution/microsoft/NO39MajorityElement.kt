package solution.microsoft

class NO39MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        val hashMap = HashMap<Int, Int>()
        nums.forEach {
            hashMap[it] = (hashMap[it] ?: 0) + 1
            if (hashMap[it]!! > nums.size / 2) {
                return it
            }
        }
        return -1
    }
}