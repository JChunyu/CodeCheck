package solution.todo

class Palindrome {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }
        var length = 0
        var temp = x
        val intArrayList = ArrayList<Int>()
        while (temp > 0) {
            length++
            val current = temp % 10
            temp /= 10
//            println(temp)
            intArrayList.add(current)
//            println(intArrayList)
        }

//        println(length)

        var start = 0
        var end = intArrayList.size - 1

        while (start < end) {
            if (intArrayList[start] == intArrayList[end]) {
                start++
                end--
            } else {
                return false
            }
        }
        return true
    }
}