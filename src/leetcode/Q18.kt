package leetcode

class Q18 {
    fun fourSumTimeout(nums: IntArray, target: Int): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        var first: Int
        var second: Int
        var third: Int
        var fourth: Int
        for (i in nums.indices) {
            first = nums[i]
            if (i + 1 < nums.size) {
                for (j in i + 1 until nums.size) {
                    second = nums[j]
                    if (j + 1 < nums.size) {
                        for (m in j + 1 until nums.size) {
                            third = nums[m]
                            if (m + 1 < nums.size) {
                                for (n in m + 1 until nums.size) {
                                    fourth = nums[n]
                                    var needToAdd = true
                                    val sum = first + second + third + fourth
                                    val temp = listOf(first, second, third, fourth)
                                    result.forEach { list ->
                                        val templist = ArrayList<Int>().apply {
                                            addAll(list)
                                        }
                                        templist.remove(first)
                                        templist.remove(second)
                                        templist.remove(third)
                                        templist.remove(fourth)
                                        if (templist.isEmpty()) {
                                            needToAdd = false
                                        }
                                    }
                                    if (needToAdd && sum == target) {
                                        result.add(arrayListOf(first, second, third, fourth))
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result
    }

    fun fourSum2(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        return loopAndWhen(nums, target)
    }

    fun loopAndWhen(nums: IntArray, target: Int): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        for (i in nums.indices - 3) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            for (j in i + 1 until nums.size - 2) {
                var m: Int = j + 1
                var n: Int = nums.size - 1
                while(m < n) {
                    val sum = nums[i] + nums[j] + nums[m] + nums[n]
                    if (sum > target) {
                        n--
                    } else if (sum < target) {
                        m++
                    } else {
                        result.add(arrayListOf(nums[i], nums[j], nums[m], nums[n]))
                    }
                }
            }
        }
        return result
    }

    // 头尾两个指针，只适合正整数
    private fun findforPlus(nums: IntArray, target: Int): List<List<Int>> {
        var first: Int
        var second: Int
        var third: Int
        var fourth: Int

        var i = 0
        var j = nums.size - 1

        val result = ArrayList<ArrayList<Int>>()

        if (nums.size < 4) {
            return emptyList()
        }

        while (i < j) {
            var m: Int = i + 1
            var n: Int = j - 1

            first = nums[i]
            fourth = nums[j]
            second = nums[m]
            third = nums[n]

            if (first + second + third + fourth > target) {
                j--
                continue
            }

            // 在满足这个条件下，才能继续遍历 m，n
            if (first + fourth <= target) {
                val tempTarget = target - first - fourth
                while (m < n) {
                    second = nums[m]
                    third = nums[n]
                    if (second + third <= tempTarget) {
                        if (second + third == tempTarget) {
                            val list = arrayListOf(first, second, third, fourth)
                            if (!result.contains(list)) {
                                result.add(arrayListOf(first, second, third, fourth))
                            }
                        }
                        m++
                    } else {
                        n--
                    }
                }
                if (second + third > tempTarget) {
                    j--
                }
                if (second + third <= tempTarget) {
                    i++
                }
            }
        }
        return result
    }

    private fun find(nums: IntArray, target: Int): List<List<Int>> {
        var first: Int
        var second: Int
        var third: Int
        var fourth: Int
        var i = 0
        var j = nums.size - 1
        val result = ArrayList<ArrayList<Int>>()

        if (nums.size < 4) {
            return emptyList()
        }

        while (i < j) {
            first = nums[i]
            // 与前一个元素相同，直接下一个
            if (i > 0 && first == nums[i - 1]) {
                i++
                continue
            }
            fourth = nums[j]
            // 与前一个元素相同，直接下一个
            if (j < nums.size - 1 && fourth == nums[j + 1]) {
                j--
                continue
            }
            var m: Int = i + 1
            var n: Int = j - 1
            while (m < n) {
                second = nums[m]
                if (m > i + 1 && second == nums[m - 1]) {
                    m++
                    continue
                }
                third = nums[n]
                if (n < j - 1 && third == nums[n + 1]) {
                    n--
                    continue
                }
                val sum = first + second + third + fourth
                if (sum < target) {
                    m++
                } else if (sum > target) {
                    n--
                } else {
                    result.add(arrayListOf(first, second, third, fourth))
                    m++
                    n--
                }
            }
            i++
            j--
        }
        return result
    }

    /*
    * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
    * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
    * 0 <= a, b, c, d < n
    * a、b、c 和 d 互不相同
    * nums[a] + nums[b] + nums[c] + nums[d] == target
    * */


    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val res = arrayListOf<List<Int>>()
        if (nums.size < 4) return res
        // 排序
        nums.sort()
        val size = nums.size
        // 从 index = 0 开始推进，直到 size - 3，实际上 a 到达的最大值是 size - 4，给 bcd 留下空间
        for (a in 0 until size - 3) {
            // a 去重
            if (a > 0 && nums[a] == nums[a - 1]) continue
            // b 从 a + 1 开始推进，直到 size - 2，实际上 b 到达的最大值是 size - 3，给 cd 留下空间
            for (b in a + 1 until size - 2) {
                // b 去重
                if (b > a + 1 && nums[b] == nums[b - 1]) continue
                var c = b + 1
                var d = size - 1
                while (c < d) {
                    val sum = nums[a].toLong() + nums[b].toLong() + nums[c].toLong() + nums[d].toLong()
                    when {
                        sum < target -> c++
                        sum > target -> d--
                        else -> {
                            res.add(listOf(nums[a], nums[b], nums[c], nums[d]))
                            while (c < d && nums[c] == nums[c + 1]) c++
                            while (c < d && nums[d] == nums[d - 1]) d--
                            c++
                            d--
                        }
                    }
                }
            }
        }
        return res
    }
}

fun main() {
    val res = Q18().fourSum(intArrayOf(-3,-1,0,2,4,5), 0)
    res.forEach { println("$it") }
}