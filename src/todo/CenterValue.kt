package todo

class CenterValue {
    fun caculate(l: Int, r: Int) {
        val c = (l + r) / 2
        val c1 = (l + r) * 0.5
        val c2 = l + (r - l) / 2
        println("normal: $c")
        println("float: $c1")
        println("better: $c2")
    }
}