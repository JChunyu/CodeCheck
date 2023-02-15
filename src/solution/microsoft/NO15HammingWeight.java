package solution.microsoft;

public class NO15HammingWeight {

    // n & n - 1 相当于只会影响最后一位的 1 ，每次与一次少一个 1 ，所以只需要记录循环次数就可以。
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // 1 << i 相当于 1 10 100 1000 这样将 1 逐步向前
            if ((n & (1 << i)) != 0) {
                res++;
            }
        }
        return res;
    }
}
// 11111111111111111111111111111101