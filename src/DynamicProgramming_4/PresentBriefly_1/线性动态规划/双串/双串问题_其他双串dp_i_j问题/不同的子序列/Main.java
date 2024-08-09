package DynamicProgramming_4.PresentBriefly_1.线性动态规划.双串.双串问题_其他双串dp_i_j问题.不同的子序列;

public class Main {

    // 取模常数
    private static final int MOD = 1000000007;

    public static int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];  // dp[i][j]表示s[0...i-1]中t[0...j-1]的子序列个数

        // 初始化
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;  // 空字符串t在s的任何子序列中都存在1次
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {  // 匹配就更新

                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
                } else { // 不匹配，继承上一个状态值

                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        String s = "rabbbit", t = "rabbit";

        System.out.println(numDistinct(s, t));

    }
}
