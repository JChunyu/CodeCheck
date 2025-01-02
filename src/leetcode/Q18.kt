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

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
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
}

fun main() {
    val res = Q18().fourSum(intArrayOf(-3,-1,0,2,4,5), 0)
    res.forEach { println("$it") }
}