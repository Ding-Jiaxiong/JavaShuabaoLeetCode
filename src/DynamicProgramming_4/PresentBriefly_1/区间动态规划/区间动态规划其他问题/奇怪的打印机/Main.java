package DynamicProgramming_4.PresentBriefly_1.区间动态规划.区间动态规划其他问题.奇怪的打印机;

public class Main {

    public static int strangePrinter(String s) {

        int n = s.length(); // 字符串长度

        int[][] dp = new int[n][n];  // dp[i][j] 表示从字符串 s 的第 i 个字符到第 j 个字符所需的最少打印次数

        // 初始
        for (int i = 0; i < n; i++) {

            dp[i][i] = 1; // 单个字符只需打印 1 次
        }

        // 计算子串的最小打印次数
        for (int length = 2; length <= n; length++) { // 从长度为 2 到 n 的所有子串

            for (int i = 0; i <= n - length; i++) {

                int j = i + length - 1;

                dp[i][j] = dp[i][j - 1] + 1; // 初始情况下，不考虑合并打印的情况

                // 遍历所有可能的分隔点
                for (int k = i; k < j; k++) {

                    // 计算将子串分成两部分的最小打印次数
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }

                // 如果子串的两端字符相同，考虑合并打印
                if (s.charAt(i) == s.charAt(j)) {

                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1]; // 打印整个字符串
    }


    public static void main(String[] args) {

        String s = "aaabbb";

        System.out.println(strangePrinter(s));

    }
}
