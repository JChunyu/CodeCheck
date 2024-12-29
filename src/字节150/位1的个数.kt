package 字节150

class HammingWeightSolution {
    fun hammingWeight(n: Int): Int {
        var ret = 0
        for (i in 0 until 32) {
            val res = n and (1 shl i)
            if (res != 0) {
                ret++
            }
        }
        return ret
    }
}