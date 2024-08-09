package DynamicProgramming_4.PresentBriefly_1.线性动态规划.双串.双串问题_其他双串dp_i_j问题.交错字符串;

public class Main {

    public static boolean isInterleave(String s1, String s2, String s3) {

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        // 长度特判
        if (len1 + len2 != len3) {
            return false;
        }

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];  // dp[i][j] 表示 s3 的前 i + j 个字符能否由 s1 的前 i 个字符和 s2 的前 j 个字符交错组成

        // 初始值
        dp[0][0] = true;  // 空串肯定没问题

        // s2 用 0 个字符，全用 s1
        for (int i = 1; i <= len1; i++) {

            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // s1 用 0 个字符，全用 s2
        for (int i = 1; i <= len2; i++) {

            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }

        // 遍历
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {

                /* dp[i][j] 为 true 的条件是：
                      1. dp[i-1][j] 为 true 且 s1 的第 i 个字符与 s3 的当前字符对应
                      2. 或者 dp[i][j-1] 为 true 且 s2 的第 j 个字符与 s3 的当前字符对应
                 */
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {

        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";

        System.out.println(isInterleave(s1, s2, s3));

    }
}
