package algorithms.bit_manipulation


class HammingWeight {
    fun hammingWeight(n:Int):Int {
        var ans = 0
        // n & n - 1 相当于只会影响最后一位的 1 ，每次与一次少一个 1 ，所以只需要记录循环次数就可以。
        for (i in 0 until 32) {
            // 1 << i 相当于 1 10 100 1000 这样将 1 逐步向前, 左移
            if (n and (1 shl i) != 0) {
                ans++
            }
        }
        return ans
    }
}