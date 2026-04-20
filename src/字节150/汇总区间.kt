package 字节150

class SummaryRangesSolution {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) return emptyList()
        if (nums.size == 1) return listOf("${nums[0]}")
        val arrayList = arrayListOf<String>()
        var i = 0
        var j = 1
        var prev = nums[0]
        while (j < nums.size) {
            val cur = nums[j]
            if (cur != prev + 1) {
                if (j - i == 1) {
                    arrayList.add("${nums[i]}")
                } else {
                    arrayList.add("${nums[i]}->${nums[j - 1]}")
                }
                i = j
            }
            prev = cur
            j++
        }
        if (i == nums.size - 1) {
            arrayList.add("${nums[i]}")
        } else {
            arrayList.add("${nums[i]}->${nums[j - 1]}")
        }
        return arrayList
    }
}

