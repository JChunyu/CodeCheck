package microsoft.find

/*
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。

给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
class RotateMinArray {
    fun minArray(numbers: IntArray): Int {
        if (numbers.isEmpty()) return -1
        var last = Int.MIN_VALUE
        var isDown = false
        for (i in numbers.indices) {
            if (last > numbers[i]) {
                isDown = true
                return numbers[i]
            }
            last = numbers[i]
        }
        return if (!isDown) {
            numbers[0]
        } else {
            last
        }
    }
}