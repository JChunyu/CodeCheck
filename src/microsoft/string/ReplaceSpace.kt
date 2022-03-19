package microsoft.string

class ReplaceSpace {
    fun replaceSpace(s: String): String {
        val stringBuilder = StringBuilder()
        s.forEachIndexed { index, c ->
            if (c == ' ') {
                stringBuilder.append("%20")
            } else {
                stringBuilder.append(c)
            }
        }
        return stringBuilder.toString()
    }
}