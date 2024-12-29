package 字节150

class ClimbStairsSolution {
    fun climbStairs(n: Int): Int {
        if (n < 2) return 1
        var i = 0 // n - 2
        var j = 0 // n - 1
        var r = 1
        for (x in 1 .. n) {
            i = j
            j = r
            r = i + j
        }
        return r
    }
}

/*
f(n) = f(n - 1) + f(n - 2)
0 start
f(0) = 1
f(1) = 1
f(2) = f(1) + f(0) =
* */