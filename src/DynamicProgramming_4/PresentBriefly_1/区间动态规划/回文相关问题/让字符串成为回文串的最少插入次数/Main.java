package DynamicProgramming_4.PresentBriefly_1.区间动态规划.回文相关问题.让字符串成为回文串的最少插入次数;

public class Main {

    // 困难题
    public static int minInsertions(String s) {

        // 字符串长度减去 最长回文子序列的长度 就是答案
        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];

        // 遍历字符串的每一个字符
        for (int i = 0; i < n; i++) { // 从前往后
            for (int j = n - 1; j >= 0; j--) { // 从后往前

                if (s.charAt(i) == s.charAt(j)) { // 如果两个字符相等，则最长回文子序列长度加1
                    dp[i + 1][n - j] = dp[i][n - j - 1] + 1;
                } else {

                    // 不相等， 则取不包含当前字符的最优解
                    dp[i + 1][n - j] = Math.max(dp[i][n - j], dp[i + 1][n - j - 1]);
                }
            }
        }

        return n - dp[n][n];
    }

    public static void main(String[] args) {

        String s = "zzazz";

        System.out.println(minInsertions(s));

    }
}
