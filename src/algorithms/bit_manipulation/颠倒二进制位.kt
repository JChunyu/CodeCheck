package algorithms.bit_manipulation

class ReverseBits {
    fun reverseBits(n: Int): Int {
        var x = n
        var rev = 0
        var i = 0
        // 32 位遍历， 且输入不为 0
        while (i < 32 && x != 0) {
            // 将 n 视作一个长为 32 的二进制串，从低位往高位枚举
            // n 的每一位，将其倒序添加到翻转结果 rev 中。
            //代码实现中，每枚举一位就将 n 右移一位，这样当前 n 的最低位就是我们要枚举的比特位。当 n 为 0 时即可结束循环。
            rev = rev or (x and 1 shl 31 - i)
            x = x ushr 1
            ++i
        }
        return rev
    }
}