package microsoft.dynamicprogramming

class NumWays {
    /*
    * 青蛙跳台阶问题 1
    * 假设最后一步为 1 or 2
    * 则，最后的步数 f(n) = f(n -1) + f(n - 2)，这样看起来就像是斐波那契数列了
    * 剩余步数的跳法有 x 种，
    *
    * n-1个台阶有f(n-1)种跳法，最后还剩一个台阶，最后青蛙只能最后一跳
    * n-2个台阶有f(n-2)种跳法，最后剩余二个台阶，有两种跳法：
    *  - 一次跳两个台阶
    *  - 一次跳一个台阶  但是这种跳法其实已经在n-1个台阶里包含了，所以 f(n) = f(n-1) + f(n-2)
    * */
    fun numWays(n: Int): Int {
        if(n == 0) return 1
        if(n == 1) return 1
        var cur = 0
        var n1 = 1
        var n2 = 0
        for (i in 2..n) {
            cur = (n1 + n2) % 1000000007
            n2 = n1
            n1 = cur
        }
        return cur
    }

    fun numWays2(n: Int): Int {
        if(n == 0) return 0
        if(n == 1) return 1
        return (numWays2(n - 1) + numWays2(n - 2)) % 1000000007
    }
}