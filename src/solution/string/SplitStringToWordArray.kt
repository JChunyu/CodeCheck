package solution.string

class SplitStringToWordArray {
    fun filter(s: String): Array<String> {
        val array = ArrayList<String>()

        var index = 0
        while (index < s.length) {
            if (s[index] != ' ') {
                var j = index
                while (j < s.length && s[j] != ' ') {
                    j++
                }
                val word = s.substring(index, j)
                array.add(word)
                index = j
            } else {
                index++
            }
        }
        return array.toTypedArray()
    }

}

fun main() {
    val s = SplitStringToWordArray()
    val array = s.filter("12726 u0_a495      20   0 5.1G  56M  29M S  0.3   0.9   0:03.10 com.chunyu.accessibilitydemo")
    array.forEach {
        println(it)
    }
}