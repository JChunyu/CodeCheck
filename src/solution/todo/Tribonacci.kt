package solution.todo/*
* 1137. N-th solution.todo.Tribonacci Number
* */
class Tribonacci {
    fun tribonacci(n: Int): Int {
        if (n <= 0) return 0
        if (n == 1 || n == 2) return 1
        val intArrayList = arrayListOf(0, 1, 1)
        var result = 0
        var index = 3
        while (index <= n) {
            result = intArrayList[index - 1] + intArrayList[index - 2] + intArrayList[index - 3]
            intArrayList.add(result)
            index++
        }
        return result
    }
}