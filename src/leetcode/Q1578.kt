package leetcode

class Solution1578 {
    fun minCost(colors: String, neededTime: IntArray): Int {
        if (colors.length <= 1) return 0
        var prev = 0
        var next = 1
        var result = 0
        while (next < colors.length) {
            if (colors[prev] == colors[next]) {
                if (neededTime[prev] <= neededTime[next]) {
                    result += neededTime[prev]
                    prev = next
                } else {
                    result += neededTime[next]
                }
            } else {
                prev = next
            }
            next++
        }
        return result
    }
}

// "aaabbbabbbb"
// [3,5,10,7,5,3,5,5,4,8,1]
// 3 5 5 3 4 4

// 5,4,8,1


// 3,5,10,3

// abaac
// 12345
//