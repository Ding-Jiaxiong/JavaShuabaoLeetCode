package DynamicProgramming_4.PresentBriefly_1.线性动态规划.双串.双串问题_字符串匹配系列.正则表达式匹配;

public class Main {

    public static boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1]; // dp[i][j] 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配

        dp[0][0] = true;  // 空字符串和空模式串 是匹配的

        // 特判处理以 * 开头
        for (int i = 1; i < n; i += 2) {
            if (p.charAt(i) == '*') {

                dp[0][i + 1] = dp[0][i - 1];  // 如果 pattern 的 j-1 和 j 是 'a*' 形式，则 dp[0][j+1] 为 true
            }
        }

        // 遍历
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (p.charAt(j - 1) == '.') {

                    // . 可以匹配一个任意字符，所以沿用
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {

                    // 两种情况
                    // 1. '*' 表示 0 次：dp[i][j-2]
                    // 2. '*' 表示 1 次或多次：dp[i-1][j]

                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                } else { // 当前字符是普通字符

                    dp[i][j] = dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1);
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
