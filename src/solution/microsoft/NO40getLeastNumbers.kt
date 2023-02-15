package solution.microsoft

class NO40getLeastNumbers {
    fun getLeastNumbers(arr: IntArray, k: Int): IntArray {
        val res = IntArray(k)
        QuickSort().quickSort(arr, 0, arr.size - 1)
        for (i in 0 until k) {
            res[i] = arr[i]
        }

        return res
    }
}

fun main() {
    NO40getLeastNumbers().getLeastNumbers(intArrayOf(3, 4, 6, 1, 2, 5), 3).forEach {
        print(it)
    }
}

// 快排
//    (1)首先设定一个分界值，通过该分界值将数组分成左右两部分。 [2]
//    (2)将大于或等于分界值的数据集中到数组右边，小于分界值的数据集中到数组的左边。此时，左边部分中各元素都小于分界值，而右边部分中各元素都大于或等于分界值。
//    (3)然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两部分，同样在左边放置较小值，右边放置较大值。右侧的数组数据也可以做类似处理。
//    (4)重复上述过程，可以看出，这是一个递归定义。通过递归将左侧部分排好序后，再递归排好右侧部分的顺序。当左、右两个部分各数据排序完成后，整个数组的排序也就完成了。
class QuickSort {
    fun quickSort(arr: IntArray, start: Int, end: Int): IntArray {
        // 取第一个作为分界值
        val center = arr[start]
        var i = start
        var j = end
        // 左右相遇时，遍历结束
        while (i < j) {
            // 左侧都小于 center
            while (i < j && arr[i] < center) {
                i++
            }
            // 右侧都小于 center
            while (i < j && arr[j] > center) {
                j--
            }
            // 左右相等，左边先移动，右边后续再处理
            if (i < j && arr[i] == arr[j]) {
                i++
            } else {
                // 右边 != 左边，左侧大于 center or 右侧小于 center ，交换位置
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
        if (i - 1 > start) {
            quickSort(arr, start, i - 1)
        }
        if (j + 1 < end) {
            quickSort(arr, j + 1, end)
        }
        return arr
    }
}