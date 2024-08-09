package DynamicProgramming_4.PresentBriefly_1.线性动态规划.双串.双串问题_字符串匹配系列.编辑距离;

public class Main {

    public static int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];  // dp[i][j] 表示将 word1 的前 i 个字符转换为 word2 的前 j 个字符所需的最小操作数

        // 初始化第一列
        // 将 word1 的前 i 个字符转换为空串所需的操作数就是删除 i 次
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // 初始化第一行
        // 将空串转换为 word2 的前 j 个字符所需的操作数就是插入 j 次
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 两个字符相等，直接继承，不需要额外操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 否则取删除、插入、替换三种操作的最小值，并加 1 代表一次操作
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        String word1 = "horse", word2 = "ros";

        System.out.println(minDistance(word1, word2));

    }
}
