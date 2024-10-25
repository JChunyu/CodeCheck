package leetcode

import java.util.concurrent.ConcurrentHashMap

/*
* 17. 电话号码的字母组合
*
* 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
* 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
* */
class Q17 {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        // define
        val map = hashMapOf<Int, List<Char>>()
        map.put(2, listOf('a', 'b', 'c'))
        map.put(3, listOf('d', 'e', 'f'))
        map.put(4, listOf('g', 'h', 'i'))
        map.put(5, listOf('j', 'k', 'l'))
        map.put(6, listOf('m', 'n', 'o'))
        map.put(7, listOf('p', 'q', 's', 'r'))
        map.put(8, listOf('t', 'u', 'v'))
        map.put(9, listOf('w', 'x', 'y', 'z'))
        // input
        val digitsInt = arrayListOf<Int>()
        digits.toCharArray().forEach {
            digitsInt.add(it.toString().toInt())
        }
        val graph = ArrayList<List<Char>>()

        digitsInt.forEachIndexed { index, i ->
            if (i in 2..9) {
                graph.add(map[i]!!)
            }
        }
        val res = arrayListOf<String>()

        val size = graph.size
        var index = 0
        while(index < size) {

            index++
        }

        deepCallback(graph, 0, res, StringBuffer())
        return res
    }

    /*
    * 递归
    * 1. 参数要有 index 或指针
    * 2. 方法代码中最开始写终止条件
    * 3. 然后要有递归调用
    * 4. 最后返回结果
    * */
    private fun deepCallback(
        graph: List<List<Char>>,
        index: Int,
        res: ArrayList<String>,
        stringBuffer: StringBuffer
    ): List<String> {
        if (index == graph.size) {
            res.add(stringBuffer.toString())
            return res
        }
        for (char in graph[index]) {
            stringBuffer.append(char)
            deepCallback(graph, index + 1, res, stringBuffer)
            stringBuffer.deleteCharAt(stringBuffer.length - 1)
        }
        return res
    }
}

fun main() {
    val res = Q17().letterCombinations("2349")
    res.forEach {
        println(it)
    }
}