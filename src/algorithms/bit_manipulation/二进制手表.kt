package algorithms.bit_manipulation

/*
* 知识点： Integer.bitCount(int) 返回参数的二进制中 1 的数量
* */
class ReadBinaryWatch {
    fun readBinaryWatch(turnedOn: Int): List<String> {
        if (turnedOn > 10) return emptyList()
        val array = arrayListOf<String>()
        for (h in 0 until 12) {
            for (m in 0 until 60) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    array.add("$h:${if (m < 10) "0$m" else m}")
                }
            }
        }
        return array
    }
}