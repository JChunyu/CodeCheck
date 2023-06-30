package language

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * @author chunyu
 * @date 2023/3/30
 * @Description
 */
interface IFinder {
    fun find(key: String): String?
}

class CustomQueue: IFinder {
    private var map = HashMap<String, String>()

    override fun find(key: String): String? {
        println(map[key])
        return map[key]
    }

    fun put(key: String, value: String) {
        map[key] = value
    }
}

class FinderInvocationHandler(private val obj: Any): InvocationHandler {
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        // 在方法执行前加入自己的逻辑
        println("FinderInvocationHandler start")
        // 调用被代理对象的方法
        val result = method?.invoke(obj, *(args ?: arrayOfNulls<Any>(0)))
        // 在方法执行后加入自己的逻辑
        println("FinderInvocationHandler   end")
        return result
    }
}

fun main() {
    val customQueue = CustomQueue().apply {
        put("a", "1")
        put("b", "2")
        put("c", "3")
    }

    val finder = Proxy.newProxyInstance(
        IFinder::class.java.classLoader,
        arrayOf(IFinder::class.java),
        FinderInvocationHandler(customQueue)
    ) as IFinder

    finder.find("c")
}