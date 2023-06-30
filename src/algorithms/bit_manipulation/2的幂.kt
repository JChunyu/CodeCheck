package algorithms.bit_manipulation
// 00010000
// 00001111
// 00000000

// 00010000
// 11110000
// 00010000

// 0011000
// 0010111
// 0010000

// 0011000 【n】
// 1100111 + 1  = 1101000 【-n】

// 0011000
// 1101000
// 0001000


/*
* 将 n 的二进制表示中最低位的那个 1 提取出来，再判断剩余的数值是否为 0
* */
class IsPowerOfTwo {
    fun isPowerOfTwo(n: Int): Boolean {
        if (n < 2) return false
        // 二进制表示中最低位，其中 & 表示按位与运算。该位运算技巧可以直接将 n 二进制表示的最低位 1 移除
        // n and (n - 1) = 0
        // n and -n = n
        val r = n and (n - 1)
        return r == 0
    }
}


