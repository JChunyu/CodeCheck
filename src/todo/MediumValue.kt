class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val total = nums1.size + nums2.size

        val real = mergeArray(nums1, nums2)
        return if (total % 2 == 0) {
            val indexLeft = total / 2
            val indexRight = indexLeft - 1
            ((real[indexLeft] + real[indexRight]) * 0.5).toDouble()
        } else {
            val indexCenter = (total / 2)
            real[indexCenter].toDouble()
        }
    }

    private fun mergeArray(nums1: IntArray, nums2: IntArray): IntArray {
        if (nums1.isEmpty()) {
            return nums2
        }

        if (nums2.isEmpty()) {
            return nums1
        }
        val newArray = IntArray(nums1.size + nums2.size)
        var index1 = 0
        var index2 = 0
        var indexRes = 0
        val temp1: IntArray
        val temp2: IntArray

        if (nums1[0] > nums2[0]) {
            temp1 = nums2
            temp2 = nums1
        } else {
            temp1 = nums1
            temp2 = nums2
        }

        while(indexRes < (temp1.size + temp2.size)) {
            if (index1 >= temp1.size) {
                while(index2 < temp2.size) {
                    newArray[indexRes++] = temp2[index2]
                    index2++
                }
                break
            }
            if (index2 >= temp2.size) {
                while(index1 < temp1.size) {
                    newArray[indexRes++] = temp1[index1]
                    index1++
                }
                break
            }

            if(temp1[index1] <= temp2[index2]) {
                newArray[indexRes++] = temp1[index1]
                index1++
            } else {
                newArray[indexRes++] = temp2[index2]
                index2++
            }
        }
        return newArray
    }
}