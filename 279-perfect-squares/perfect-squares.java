class Solution {
    public static int numSquares(int n) {
        while (n % 4 == 0) {  // 消掉4的因子
            n /= 4;
        }

        if (n % 8 == 7) {  // 只能4个数表示的
            return 4;
        }

        for (int i = 0; i * i <= n; i++) {  // 去看看是2个数还是1个数
            int a = (int) Math.sqrt(n - i * i);
            if (a * a + i * i == n) {
                return i > 0 && a > 0 ? 2 : 1;
            }
        }

        return 3;  // 剩下的只能用3个数表示
    }

}