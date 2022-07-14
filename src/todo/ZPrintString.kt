class ZPrintString {
    fun convert(s: String, numRows: Int): String {
        // 极限情况
        if (s.isEmpty()) return ""
        if (numRows <= 0) return ""
        if (numRows >= s.length || numRows == 1) return s

        val charArray = s.toCharArray()
        var isSeq = true
        var curIndex = 0
        var index = 0
        // n个数组的最大程度是都放在同一个数组中
        val arrays = Array(numRows) {
            StringBuffer()
        }
        while(index < charArray.size) {
            if (isSeq) {
                if(curIndex < numRows) {
                    arrays[curIndex].append(charArray[index])
                    curIndex++
                    index++
                    if (curIndex == numRows) {
                        curIndex = numRows - 1
                        isSeq = false
                    }
                }
            } else {
                if(curIndex > 0) {
                    curIndex--
                    arrays[curIndex].append(charArray[index])
                    index++
                    if (curIndex == 0) {
                        curIndex = 1
                        isSeq = true
                    }
                }
            }
        }
        val result = StringBuffer()
        arrays.forEach {
            result.append(it)
            println(it.toString())
        }
        return result.toString()
    }

    fun convert2(s: String, numRows: Int): String {
        val charArray = s.toCharArray()
        val arrays = Array(numRows) {
            StringBuilder()
        }
        var isSeq = true
        charArray.forEachIndexed { index, c ->
            val value = if (isSeq) {
                index % numRows
            } else {
                numRows - 1 - (index % numRows)
            }
            if (isSeq && value == 0) {
                isSeq = false
            }
            if (!isSeq && value == 0) {
                isSeq = false
            }
            arrays[value].append(c)
            println("row$value:${arrays[value].toString()}")
        }
        val result = StringBuilder()
        arrays.forEach {
            result.append(it)
            println(it.toString())
        }
        return result.toString()
    }
}