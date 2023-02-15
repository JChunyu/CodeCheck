package solution.microsoft.backtracking

class TranslateNum {
    /*
    * f(i)=f(i−1)+f(i−2)[i−1≥0,10≤x≤25]
    *
    * def translateNum(self, num) :
        if num < 10 : return 1

        if 10 <= num % 100 <= 25 :
            return self.translateNum(num // 10) + self.translateNum(num // 100)
        else :
            return self.translateNum(num // 10)
    * */
    fun translateNum(num: Int): Int {
        if (num < 10) {
            return 1
        }
        // % 100 确保最大 2 位数
        return if ((num % 100) in 10..25) {
            // 10-25之间，结果等于 1位数 + 2位数 的和
            translateNum(num / 10) + translateNum(num / 100)
        } else {
            // 其他的就返回一位数
            translateNum(num / 10)
        }
    }
}