package leetcode

fun divide(dividend: Int, divisor: Int): Int {
    if (divisor == 0 || dividend == 0) return 0
    if (dividend == Int.MIN_VALUE && divisor == -1) return Int.MAX_VALUE

    val sameSign = (dividend >= 0) == (divisor >= 0)
    var a = kotlin.math.abs(dividend.toLong())
    val b = kotlin.math.abs(divisor.toLong())

    var res = 0L
    // Use bit shifting to subtract large chunks each step, avoiding TLE
    for (shift in 31 downTo 0) {
        // a / 2 后仍大于 b
        if ((a shr shift) >= b) {
            // res 加上 1 x 2 的 shift 次
            res += 1L shl shift
            // a 再减去 b 左移动 shift 次
            a -= b shl shift
        }
    }

    res = if (sameSign) res else -res
    return when {
        res > Int.MAX_VALUE -> Int.MAX_VALUE
        res < Int.MIN_VALUE -> Int.MIN_VALUE
        else -> res.toInt()
    }
}
