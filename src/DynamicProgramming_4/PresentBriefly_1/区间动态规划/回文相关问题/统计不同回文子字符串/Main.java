package DynamicProgramming_4.PresentBriefly_1.区间动态规划.回文相关问题.统计不同回文子字符串;

public class Main {

    private static final int MOD = 1000000007;

    public static int countPalindromicSubsequences(String s) {

        // 困难题
        int n = s.length();

        int[][] dp = new int[n][n];  //  dp[i][j] 表示 s[i..j] 中不同非空回文子序列的个数

        // 初始化，单个字符的情况
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // 大于 1
        for (int length = 2; length <= n; length++) {

            for (int i = 0; i <= n - length; i++) {

                int j = i + length - 1;

                if (s.charAt(i) == s.charAt(j)) {

                    // 从 i+1 到 j-1 的子序列中加入 s[i] 和 s[j] 后，计算不同的回文子序列个数
                    int left = i + 1;
                    int right = j - 1;

                    // 尝试找到左边界和右边界相同的字符
                    while (left <= right && s.charAt(left) != s.charAt(i)) left++;
                    while (left <= right && s.charAt(right) != s.charAt(j)) right--;

                    if (left > right) {

                    /*
                        如果 left > right，说明没有与 s[i]、s[j] 相同的字符
                        新的回文子序列是由 dp[i+1][j-1] 的所有回文子序列加上 s[i] 和 s[j] 组成的
                     */

                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    } else if (left == right) {

                        /*
                            如果 left == right，说明只有一个与 s[i]、s[j] 相同的字符
                            新的回文子序列是由 dp[i+1][j-1] 的所有回文子序列加上 s[i]、s[j] 组成的
                         */

                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;

                    } else {

                        /*
                            如果 left < right，说明有两个或更多与 s[i]、s[j] 相同的字符
                            新的回文子序列是由 dp[i+1][j-1] 的所有回文子序列减去 dp[left+1][right-1] 的重复回文子序列
                         */

                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[left + 1][right - 1];
                    }
                } else {

                    // s[i] 和 s[j] 不相等
                    // dp[i][j] 的回文子序列数为 dp[i+1][j] 和 dp[i][j-1] 的和，减去重复计算的 dp[i+1][j-1]

                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }

                if (dp[i][j] < 0) dp[i][j] += MOD;

                dp[i][j] %= MOD;
            }
        }


        return dp[0][n - 1];  // s[0..n-1] 中不同非空回文子序列的个数

    }

    public static void main(String[] args) {

        String s = "bccb";

        System.out.println(countPalindromicSubsequences(s));
    }
}
