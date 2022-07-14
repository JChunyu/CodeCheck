package todo/*
* 11. 盛最多水的容器
* */
class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var max = 0

        while (left < height.size - 1) {
            val result = Math.min(height[left], height[right]) * (right - left)
            max = if (result > max) result else max
            if (height[right] < height[left]) {
                --right
            } else {
                left++
            }
        }
        return max
    }
}

