package algorithms

class ArrayProj {
    /*
    * 135. 分发糖果
    *   n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
        你需要按照以下要求，给这些孩子分发糖果：

        每个孩子至少分配到 1 个糖果。
        相邻两个孩子评分更高的孩子会获得更多的糖果。
        请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
    * */
    fun candy(ratings: IntArray): Int {
        if (ratings.isEmpty()) return 0
        var candys = IntArray(ratings.size) { 1 }

        var i = 0
        var j = i + 1

        while (j < ratings.size) {
            if (ratings[i] > ratings[j]) {
                if (candys[i] <= candys[j]) {
                    candys[i] = candys[j] + 1
                    var m = i - 1
                    var n = i
                    while (m >= 0 && candys[m] <= candys[n] && ratings[m] > ratings[n]) {
                        candys[m] = candys[n] + 1
                        m--
                        n--
                    }
                }
            } else if (ratings[i] < ratings[j]) {
                candys[j] = candys[i] + 1
            }
            i++
            j++
        }
        return candys.sum()
    }
}

fun main() {
    val proj = ArrayProj()
    val i = proj.candy(intArrayOf(87,2,1))
    println(i)
}