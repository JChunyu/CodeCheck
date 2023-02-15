package solution.microsoft.find

class SearchNumAppearTimes {
    fun search(nums: IntArray, target: Int): Int {
        var time = 0
        nums.forEach {
            if (it == target) {
                time++
            }
        }
        return time
    }
}