package DynamicProgramming_4.PresentBriefly_1.区间动态规划.回文相关问题.最长回文子串;

public class Main {

    public static String longestPalindrome(String s) {

        int len = s.length();  // 字符串长度

        if (len < 2) return s;  // 单字符和空字符串都是回文的

        int maxLen = 1; // 最长回文子串长度
        int begin = 0;  // 最长回文子串起始位置

        boolean[][] dp = new boolean[len][len]; // 子串是否回文

        char[] charArray = s.toCharArray();

        // 初始化 dp 数组
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;  // 每个单字符肯定回文
        }

        // 遍历所有长度大于 1 的子串
        for (int j = 1; j < len; j++) {  // j 是结束位置

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

                // 更新结果
                if (dp[i][j] && j - i + 1 > maxLen) {

                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        // 返回从 begin 开始，长度为 maxLen 的子串
        return s.substring(begin, begin + maxLen);

    }

    public static void main(String[] args) {

        String s = "babad";

        System.out.println(longestPalindrome(s));

    }
}
