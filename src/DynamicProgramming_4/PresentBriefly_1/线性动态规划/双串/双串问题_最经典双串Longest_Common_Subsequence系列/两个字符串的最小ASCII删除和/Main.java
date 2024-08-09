package DynamicProgramming_4.PresentBriefly_1.线性动态规划.双串.双串问题_最经典双串Longest_Common_Subsequence系列.两个字符串的最小ASCII删除和;

public class Main {

    public static int minimumDeleteSum(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];  // dp[i][j]表示使s1[0...i-1]和s2[0...j-1]相等所需删除字符的最小ASCII值和

        // 初始化第一列
        // 当s2为空时，使s1的前i个字符全删所需的最小ASCII值和
        for (int i = 1; i <= m; i++) {

            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }

        // 初始化第一行
        // 当s1为空时，使s2的前j个字符全删所需的最小ASCII值和
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
        }

        // 遍历所有字符
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    // 相等的话，就不用删除，直接沿用前面的
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    // 在s1[i-1]和s2[j-1]中删除一个字符，取删除后的最小值
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }

        return dp[m][n];

    }

    public static void main(String[] args) {

        String s1 = "sea";
        String s2 = "eat";

        System.out.println(minimumDeleteSum(s1, s2));

    }
}
