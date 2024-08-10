package DynamicProgramming_4.PresentBriefly_1.区间动态规划.回文相关问题.回文子串;

public class Main {

    public static int countSubstrings(String s) {

        int count = 0;

        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        char[] charArray = s.toCharArray();

        // 初始化 dp 数组
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;  // 每个单字符肯定回文
            count++;
        }

        // 遍历所有长度大于 1 的子串
        for (int j = 1; j < n; j++) {  // j 是结束位置

            for (int i = 0; i < j; i++) {  // i 是起始位置

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;  // 不同，不是回文
                } else {

                    // 如果两个字符相同，检查子串是否回文
                    if (j - i < 3) {
                        dp[i][j] = true;  // 如果子串长度为2或3，直接标记为回文
                    } else {

                        dp[i][j] = dp[i + 1][j - 1]; // 否则，子串回文性取决于去掉两端字符后的子串

                    }
                }

                if (dp[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String s = "abc";

        System.out.println(countSubstrings(s));

    }
}
