package algorithms.sliding_window

class Boomerang {
    fun isBoomerang(points: Array<IntArray>): Boolean {
        if (points.size != 3) return false
        val one = points[0]
        val two = points[1]
        val thr = points[2]
        var line1 = (one[0] - two[0]).toFloat() / (one[1] - two[1]).toFloat()
        if (line1.isNaN()) {
            line1 = 0f
        }
        println(line1)
        var line2 = (two[0] - thr[0]).toFloat() / (two[1] - thr[1]).toFloat()
        if (line2.isNaN()) {
            line2 = 0f
        }
        println(line2)
        var line3 = (one[0] - thr[0]).toFloat() / (one[1] - thr[1]).toFloat()
        if (line3.isNaN()) {
            line3 = 0f
        }
        println(line3)
        if (line1 == line2 && line2 == line3 && line1 == line3) return false
        return true
    }
}

fun main() {
    val s = Boomerang().isBoomerang(arrayOf(intArrayOf(0,0), intArrayOf(1, 1), intArrayOf(1, 1)))
    println(s)
}