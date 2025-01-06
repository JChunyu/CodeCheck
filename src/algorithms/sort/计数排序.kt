package algorithms.sort

import kotlin.math.max
import kotlin.math.min

fun countSort(array: IntArray): IntArray {
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    for (i in array.indices) {
        min = min(min, array[i])
        max = max(max, array[i])
    }
    val countArray = IntArray(max - min + 1) { 0 }
    array.forEach { it ->
        countArray[it - min]++
    }
    var index = 0
    for (i in min until countArray.size) {
        while (countArray[i] > 0) {
            array[index++] = i
            countArray[i]--
        }
    }
    return array
}

fun main() {
    val array = intArrayOf(0, 0, 0)
    val res = countSort(array)
    res.forEach { print(it) }
}