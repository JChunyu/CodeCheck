package leetcode

import kotlin.math.min

class Q274 {
    fun hIndex2(citations: IntArray): Int {
        for (i in citations.indices) {
            for (j in i until citations.size) {
                if (citations[i] < citations[j]) {
                    val temp = citations[j]
                    citations[j] = citations[i]
                    citations[i] = temp
                }
            }
        }
        var h = 0
        var sum = 0
        while (h < citations.size) {
            if (citations[h] >= (h + 1)) {
                sum++
            }
            h++
        }
        return sum
    }


    fun hIndex3(citations: IntArray): Int {
        val counts = IntArray(citations.size + 1)
        for (i in 1 .. citations.size) {
            val index = i - 1
            var curRef = citations[index]
            val refIndex = min(curRef, counts.size - 1)
            for (j in 0..refIndex) {
                counts[j]++
            }
        }
        var h = counts.size - 1
        while (h >= 0) {
            if (counts[h] >= h) {
                break
            }
            h--
        }
        return h
    }


    fun hIndex(citations: IntArray): Int {
        // [0, n]
        val n = citations.size
        val counts = IntArray(citations.size + 1)
        for (i in 0 until n) {
            if (citations[i] >= n) {
                counts[n]++
            } else {
                counts[citations[i]]++
            }
        }
        var h = 0
        for (i in n downTo 0) {
            h += counts[i]
            if (h >= i) {
                return i
            }
        }
        return 0
    }
}

fun main() {
    println(Q274().hIndex(intArrayOf(3,0,6,1,5)))
}

/*

1 2 3

3,0,6,1,5
1 2 3 4 5



* */