package solution.microsoft

class NO16myPow {
    fun myPow(x: Double, n: Int): Double {
        var res = 1.0
        var m = n

        if (n == 0) {
            return 1.0
        } else if (n > 0) {
            while (m > 0) {
                res *= x
                m--
            }
        } else {
            m = Math.abs(n)
            while (m > 0) {
                res /= x
                m--
            }
        }
        return res
    }

    /*
    * 快速幂算法:「快速幂算法」的本质是分治算法,每次直接把上一次的结果进行平方，以减少计算次数
    *
    * */
    fun myPow2(x: Double, n: Int): Double {
        if (n == 0) return 1.0
        if (n == 1) return x
        if (n == -1) return 1 / x
        val half: Double = myPow(x, n / 2)
        val mod: Double = myPow(x, n % 2) // n % 2 的结果是 0 / 1，为 0 时  myPow = 1 为 1 时，为 x ，所以相当于在对 n 为奇数的情况单独处理。
        return half * half * mod
    }
}