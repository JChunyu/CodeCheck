package algorithms.string

class IsCircularSentence {
    fun isCircularSentence(sentence: String): Boolean {
        val array = sentence.split(' ')
        array.forEach { println(it) }
        var prev = array.first().first()
        var last = array.last().last()
        for (i in array.indices) {
            if (prev == array[i].first()) {
                prev = array[i].last()
            } else {
                return false
            }
        }
        if (prev != last) {
            return false
        }
        return true
    }
}

fun main() {
    val res = IsCircularSentence().isCircularSentence("Leetcode eisc cool")
    println("result = $res")
}