package algorithms.bit_manipulation

/*
* 知识点：
* 异或操作，比较两个数二进制位是否不同，
* 0 xor 1 = 1
* 0 xor 0 = 0
* 1 xor 1 = 0
* 1 xor 0 = 1
*
* 每次左移相当于乘以 2
*
* 1 不断左移，然后与一个数进行与操作，可以检查这个数中 1 的数量
* */
class HammingDistance {
    fun hammingDistance(x: Int, y: Int): Int {
        val r = x xor y
        var count = 0
        for (i in 0 until 32) {
            if ((r and  (1 shl i) != 0)) {
                count++
            }
        }
        return count
    }
}

fun main() {
    val n = HammingDistance().hammingDistance(12, 9)
    println(n)
}