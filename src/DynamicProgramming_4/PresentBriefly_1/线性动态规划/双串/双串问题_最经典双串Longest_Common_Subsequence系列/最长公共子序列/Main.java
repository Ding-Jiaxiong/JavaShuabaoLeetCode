package DynamicProgramming_4.PresentBriefly_1.线性动态规划.双串.双串问题_最经典双串Longest_Common_Subsequence系列.最长公共子序列;

public class Main {

    public static int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];  // dp[i][j] 表示text1[0...i-1] 和 text2[0...j-1] 的最长公共子序列长度


        // 遍历所有字符
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) { // 字符相等，最长公共子序列长度 + 1

                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {

                    // 否则，取前一个状态中的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        String text1 = "abcde";
        String text2 = "ace";

        System.out.println(longestCommonSubsequence(text1, text2));
    }
}
