package DynamicProgramming_4.PresentBriefly_2.计数问题.铺砖问题.多米诺和托米诺平铺;

public class Main {

    public static int numTilings(int n) {

        int mod = 1000000007;  // 取模常数

        // 特判
        if (n <= 2) return n;

        long[] dp = new long[n + 1];  // dp[i] 表示填充2 x i面板的方案数

        // 初始化
        dp[0] = dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {

            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % mod;  // 递推式：dp[n] = 2 * dp[n - 1] + dp[n - 3];
        }

        return (int) dp[n];  // 铺设2 x n面板
    }

    public static void main(String[] args) {

        int n = 3;

        System.out.println(numTilings(n));

    }
}
