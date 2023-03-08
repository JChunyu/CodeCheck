package algorithms.dynamic_programming

class ClimbStairs {
    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2
        return climbStairs(n - 1) + climbStairs(n - 2)
    }

    fun climbStairs2(n: Int): Int {
        var before = 0
        var prev = 0
        var current = 1

        for (i in 1..n) {
            before = prev
            prev = current
            current = before + prev
        }
        return current
    }

}