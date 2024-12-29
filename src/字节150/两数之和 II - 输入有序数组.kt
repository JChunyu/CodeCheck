package 字节150

class Two2SumSolution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var head = 0
        var tail = numbers.size - 1
        while (head < tail) {
            val sum = numbers[head] + numbers[tail]
            if (sum == target) {
                return intArrayOf(head + 1, tail + 1)
            } else if (sum > target) {
                tail--
            } else {
                head++
            }
        }
        return intArrayOf(-1, -1)
    }
}