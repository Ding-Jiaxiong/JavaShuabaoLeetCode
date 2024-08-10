package DynamicProgramming_4.PresentBriefly_1.区间动态规划.回文相关问题.最长回文子序列;

public class Main {

    public static int longestPalindromeSubseq(String s) {

        int n = s.length();  // 字符串长度

        if (n == 1) return 1;

        int[][] dp = new int[n][n];  // 子序列的回文长度

        // 初始化，长度为 1 的子序列一定回文
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // 长度大于 1，遍历所有可能的子序列
        for (int sublen = 2; sublen <= n; sublen++) {

            for (int i = 0; i < n - sublen + 1; i++) { // i 是子序列的起始位置

                int j = i + sublen - 1;  // j 表示子序列的结束位置

                // 端点字符相同
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;  // 端点字符加2，加上去掉端点字符后的子序列的回文长度

                } else {

                    // 如果端点字符不同，取去掉一个端点字符后的最大回文子序列长度
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {

        String s = "bbbab";

        System.out.println(longestPalindromeSubseq(s));

    }
}
