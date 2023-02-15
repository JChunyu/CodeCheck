package solution.microsoft

class NO61isStraight {
    //从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
    // 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
    //
    fun isStraight(nums: IntArray): Boolean {
        val maxLength = 5
        var zeroNum = 0
        val sortedNums = nums.sorted()
        // 记录 0 的数量
        while (sortedNums[zeroNum] == 0) {
            zeroNum++
        }
        var current = sortedNums[zeroNum]
        for (i in zeroNum + 1 until 5) {
            // 非 0 重复直接 false
            if (current == sortedNums[i]) {
                return false
            }
            // next = current + 1，如果不等于，需要消耗一个 0 来补位
            while (current + 1 != sortedNums[i]) {
                current += 1
                zeroNum--
            }
            current = sortedNums[i]
        }
        return zeroNum >= 0
    }

    fun isStraight2(nums: IntArray): Boolean {
        var zeroNum = 0
        val sortedNums = nums.sorted()
        // 记录 0 的数量
        while (sortedNums[zeroNum] == 0) {
            zeroNum++
        }
        var index = zeroNum
        var current = sortedNums[index]
        index++
        while (index < 5) {
            if (sortedNums[index] == current) {
                return false
            } else if (sortedNums[index] > current + 1) {
                zeroNum -= sortedNums[index] - current - 1
            }
            current = sortedNums[index]
            index++
        }
        return zeroNum >= 0
    }
}