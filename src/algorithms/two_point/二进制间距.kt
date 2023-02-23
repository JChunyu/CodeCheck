package algorithms.two_point

class BinaryGap {
    fun binaryGap(n: Int): Int {
        var n = n
        var last = -1
        var ans = 0
        var i = 0
        while (n != 0) {
            if (n and 1 == 1) {
                if (last != -1) {
                    ans = Math.max(ans, i - last)
                }
                last = i
            }
            n = n shr 1
            ++i
        }
        return ans
    }
}
