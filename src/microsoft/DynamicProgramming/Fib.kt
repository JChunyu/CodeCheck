package microsoft.DynamicProgramming

class Fib {
    /*
    * 使用记忆上一个值的形式，减少时间复杂度。
    * */
    val MOD = 1000000007
    fun fib(n: Int): Int {
        if(n == 0) return 0
        if(n == 1) return 1
        var n2 = 0
        var n1 = 1
        var cur = 0
        for(i in 2..n) {
            cur = (n1 + n2) % MOD
            n2 = n1
            n1 = cur
        }
        return cur
    }

    /*
    * 回溯算法，时间复杂度高。
    * */
    fun fib2(n: Int): Int {
        if(n == 0) return 0
        if(n == 1) return 1
        return (fib2(n - 1) + fib2(n - 2)) % MOD
    }
}