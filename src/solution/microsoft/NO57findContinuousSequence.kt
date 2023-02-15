package solution.microsoft

class NO57findContinuousSequence {
    fun findContinuousSequence(target: Int): Array<IntArray> {
        var l = 1
        var sum = 0
        val list = ArrayList<IntArray>()
        // 首先，拆分的范围肯定是小于 target ，因为如果是 target ，只需要一个数就可以了。
        for (i in 1 until target) {
            sum += i // 计算和
            // 当和大于 target，左侧指针向右移动。
            while (sum > target) {
                sum -= l
                l++
            }
            // 当遇到相等时，将这组数字记录到临时数组 temp 中。temp 的长度是包括从 l 到 i 的，
            if (target == sum) {
                val temp = IntArray(i - l + 1)
                for (j in temp.indices) {
                    temp[j] = l + j
                }
                list.add(temp)
            }
        }
        return list.toTypedArray()
    }
}