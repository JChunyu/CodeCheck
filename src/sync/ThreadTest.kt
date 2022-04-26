package sync

class ThreadTest {
    fun testStateEmun() {
        //线程状态枚举类
        val values = Thread.State.values()
        for (value in values) {
            val name = value.name
            println(name)
        }
    }
}

fun main() {
    ThreadTest().testStateEmun()
}

