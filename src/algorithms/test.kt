package algorithms

data class SomeClass(val stringValue: String)

fun main() {
    val list: List<SomeClass>? = listOf(
        SomeClass("daimler.gen20xi2.player.bta1"),
        SomeClass("other.value"),
        SomeClass("daimler.gen20xi2.player.bta2")
    )

    val result = list?.filter { it.stringValue.startsWith("daimler.gen20xi2.player.bta") }
        ?.map { it.stringValue }

    val combinedResult = list?.mapNotNull {
        if (it.stringValue.startsWith("daimler.gen20xi2.player.bta")) {
            it.stringValue
        } else {
            null
        }
    }

    println(result)
    println(combinedResult)
}