package 字节150

import java.util.LinkedList

class SimplifyPathSolution {
    fun simplifyPath(path: String): String {
        val words = path.split('/')
        val linkedList = LinkedList<String>()
        if (words.isNotEmpty()) {
            linkedList.offer("/")
        }
        words.forEach {
            when(it) {
                "." -> {}
                ".." -> {
                    linkedList.removeLast()
                }
                else -> {
                    if (it.isNotEmpty()) {
                        linkedList.offer("$it/")
                    }
                }
            }
        }
        val stringBuilder = StringBuilder()
        if (linkedList.isEmpty()) {
           return "/"
        } else {
            linkedList.forEach {
                stringBuilder.append(it)
            }
            if (stringBuilder.last() == '/') {
                stringBuilder.dropLast(1)
            }
        }
        return stringBuilder.toString().dropLast(1)
    }
}

fun main() {
    println(SimplifyPathSolution().simplifyPath("/.../a/../b/c/../d/./"))
}