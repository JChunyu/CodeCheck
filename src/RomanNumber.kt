class RomanNumber {
    private val values = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    private val symbols = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

    fun intToRoman(num: Int): String {
        val roman = StringBuffer()
        var number = num
        for (i in values.indices) {
            val value = values[i]
            val symbol = symbols[i]
            while (num >= value) {
                number -= value
                roman.append(symbol)
            }
            if (number == 0) {
                break
            }
        }
        return roman.toString()
    }
}