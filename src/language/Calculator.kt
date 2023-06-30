package language

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy


internal interface Calculator {
    fun add(a: Int, b: Int): Int
}

internal class CalculatorInvocationHandler(private val target: Any) : InvocationHandler {
    override fun invoke(proxy: Any?, method: Method, args: Array<Any?>?): Any {
        println("Before method execution...")
        val result: Any = method.invoke(target, *(args ?: arrayOfNulls<Any>(0)))
        println("After method execution...")
        return result
    }
}

fun main() {
    val calculator = Proxy.newProxyInstance(
        Calculator::class.java.classLoader,
        arrayOf<Class<*>>(Calculator::class.java),
        CalculatorInvocationHandler(CalculatorImpl())
    ) as Calculator
    println(calculator.add(2, 3))
}

internal class CalculatorImpl : Calculator {
    override fun add(a: Int, b: Int): Int {
        return a + b
    }
}