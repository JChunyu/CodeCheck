package algorithms

fun swap(a: Int, b: Int) {
    var i = a
    var j = b
    val temp = i
    i = j
    j = temp
}


fun main() {
    var a = 100
    var b = 200
    swap(a, b)
    println("a = $a, b = $b")
}