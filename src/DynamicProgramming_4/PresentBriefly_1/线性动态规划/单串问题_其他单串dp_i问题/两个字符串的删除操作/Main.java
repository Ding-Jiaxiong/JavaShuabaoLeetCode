package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串问题_其他单串dp_i问题.两个字符串的删除操作;

public class Main {

    public static int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];  // dp[i][j] 表示将 word1 的前 i 个字符转换为 word2 的前 j 个字符所需的最小步数

        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;  // 将 word1 的前 i 个字符转换为空字符串，需要删除 i 个字符
        }

        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;   // 空字符串转换为 word2 的前 i 个字符，需要添加 i 个字符
        }

        for (int i = 1; i <= word1.length(); i++) {

            for (int j = 1; j <= word2.length(); j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 当前字符相同，不需要额外步骤
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 否则，需要删除一个字符
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }

            }
        }

        return dp[word1.length()][word2.length()];  // 结果就是将 word1 转换为 word2 所需的最小步数
    }

    public static void main(String[] args) {

        String word1 = "sea";
        String word2 = "eat";

        System.out.println(minDistance(word1, word2));

    }
}
