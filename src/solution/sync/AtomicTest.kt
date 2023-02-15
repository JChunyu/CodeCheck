package solution.sync

import java.util.concurrent.atomic.AtomicInteger

class AtomicTest {
    fun incrementAndGet(a: AtomicInteger): Int {
        var pre: Int
        var next: Int
        do {
            pre = a.get()
            next = pre + 1
        } while (!a.compareAndSet(pre, next))
        return next
    }

    fun get(a: AtomicInteger): Int {
        return a.getAndIncrement()
    }
}