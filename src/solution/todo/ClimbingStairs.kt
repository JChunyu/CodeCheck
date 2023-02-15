package solution.todo/*
*
* */
class ClimbingStairs {
    fun climbStairs(n: Int): Int {
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

    fun climbStairs2(n: Int): Int {
        if (n == 1) {
            return 1
        }
        if (n == 2) {
            return 2
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2)
    }
}