package algorithms.binary_search

/*
* 二分查找的变种
* */
class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var left  = 1
        var right = n
        while (left <= right) {
            val center = (right - left) / 2 + left
            var next: Int
            if (isBadVersion(center)) {
                right = center - 1
                next = right
            } else {
                left = center + 1
                next = left
            }
            if (isBadVersion(center) && !isBadVersion(next)) {
                return center
            }
        }
        return -1
    }
}

// mock
open class VersionControl() {
    fun isBadVersion(n: Int): Boolean = n > 3

    open fun firstBadVersion(n: Int) : Int {
        return -1
    }
}