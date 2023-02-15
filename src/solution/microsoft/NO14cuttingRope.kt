package solution.microsoft

class NO14cuttingRope {
    // n = n / 2 + n / 2
    // f(n) = f(n / 2) * f(n / 2)
    // F(n / 2)
    // f(1) = 1
    // f(2) = 1
    // f(3) = 2
    // f(4) = 4
    // f(5) = 6
    // f(6) = 9
    // f(7) = 12

    // n 能拆成几个3 + 几个 2

    // no 15 多了一个取模操作，这个操作在 kotlin 中需要使用 long 类型
    fun cuttingRope(n: Int): Int {
        if (n == 1 || n == 2) return 1
        if (n == 3) return 2
        var res: Long = 1
        var num3 = n / 3
        val num2 = when(n % 3) {
            2 -> {
                1
            }
            1 -> {
                num3--
                2
            }
            else -> 0
        }

        for (i in 1..num3) {
            res *= 3
            res %= 1000000007
        }
        for (i in 1..num2) {
            res *= 2
            res %= 1000000007
        }
        return res.toInt()
    }

    fun cuttingRope2(n: Int): Int {
        var n = n
        if (n == 2) return 1
        if (n == 3) return 2
        var res: Long = 1
        while (n > 4) {
            res *= 3
            res %= 1000000007
            n -= 3
        }
        return (res * n % 1000000007).toInt()
    }
}

fun main() {
    println(NO14cuttingRope().cuttingRope(3))
}