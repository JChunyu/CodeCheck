package leetcode

/*
* 557. 反转字符串中的单词 III
* 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
* */
fun reverseWords(s: String): String {
    var first = 0
    var last = 0
    val result = StringBuilder()
    for (i in s.indices) {
        if (s[i] == ' ') {
            // do reverse
            s.substring(first, last + 1).reversed().let {
                result.append(it)
                result.append(' ')
            }
            first = i + 1
        } else {
            last = i
        }
    }
    if (first <= last) {
        s.substring(first, last + 1).reversed().let {
            result.append(it)
        }
    }
    return result.toString()
}


fun reverseWords2(s: String): String {
    return s.split(' ').joinToString(" ") { it.reversed() }
}