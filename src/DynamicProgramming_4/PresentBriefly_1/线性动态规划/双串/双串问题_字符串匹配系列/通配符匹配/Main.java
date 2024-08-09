package DynamicProgramming_4.PresentBriefly_1.线性动态规划.双串.双串问题_字符串匹配系列.通配符匹配;

public class Main {

    public static boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];  // dp[i][j] 表示输入字符串 s 的前 i 个字符和字符模式 p 的前 j 个字符是否匹配。

        // 初始状态
        dp[0][0] = true;  // 空字符串和空模式是匹配的

        // 处理字符模式以 '*' 开头的情况，这些 '*' 可以匹配空字符串
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        // 遍历字符串和模式串
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // ? 可以匹配一个，或者当前遍历字符相同
                if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {

                    // 沿用
                    dp[i][j] = dp[i - 1][j - 1];

                } else if (p.charAt(j - 1) == '*') {  // 模式串来了一个 *

                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];  // 看前面的能不能匹配
                }
            }
        }

        return dp[m][n];

    }

    public static void main(String[] args) {

        String s = "aa", p = "a";

        System.out.println(isMatch(s, p));
    }
}
