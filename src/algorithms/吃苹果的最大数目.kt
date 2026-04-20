import java.util.LinkedList
import kotlin.math.max

class SolutionEatenApples {
    class Apple(var create: Int, var end: Int)
    fun eatenApples(apples: IntArray, days: IntArray): Int {
        val n = apples.size
        val linkedList = LinkedList<Apple>()
        var maxDay = 0
        // 统计每天有几个苹果到期
        for (i in 0 until n) {
            val endDayIndex = i + days[i]
            maxDay = max(maxDay, endDayIndex)
        }
        // 开始吃
        var result = 0
        var leftCount = 0
        for (j in 0 until maxDay) {
            // 先移除今日到期的苹果
            linkedList.removeIf { it.end == j }
            // 创建今天的苹果
            val todayAddCount = if (j < n) {
                apples[j]
            } else {
                0
            }
            for (m in 0 until todayAddCount) {
                val apple = Apple(j, j + days[j])
                linkedList.add(apple)
            }
            // 添加完重排序
            linkedList.sortBy { it.end }
            // 开始吃
            val apple = linkedList.peekFirst()
            if (apple != null) {
                result++
            }
        }
        return result
    }
}

fun main() {
    val array = arrayOf(3,1,1,0,0,2)
    val days = arrayOf(3,1,1,0,0,2)
    val res = SolutionEatenApples().eatenApples(array.toIntArray(), days.toIntArray())
    println("res - $res")
}
