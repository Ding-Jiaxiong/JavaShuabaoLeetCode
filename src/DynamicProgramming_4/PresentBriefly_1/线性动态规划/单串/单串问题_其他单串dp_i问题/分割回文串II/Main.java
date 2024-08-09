package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_其他单串dp_i问题.分割回文串II;

public class Main {

    public static int minCut(String s) {

        int[] dp = new int[s.length()];  // dp[i] 表示以s[i] 字符结尾的字符串的最少分割次数

        boolean[][] isPalindrome = new boolean[s.length()][s.length()];  // isPalindrome[i][j] 表示 s[i:j] 是否是回文串

        // 每个位置的最大分割次数就是每个字符都单独分割，初始化 dp
        for (int i = 0; i < s.length(); i++) {
            dp[i] = i;
        }

        for (int i = 0; i < s.length(); i++) {

            for (int j = 0; j <= i; j++) {

                // 检查 s[j:i] 是否回文
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || isPalindrome[j + 1][i - 1])) {

                    isPalindrome[j][i] = true;  // 如果是回文，进行设置

                    // 如果s[0:i] 是回文，dp[i] 为 0，因为不需要分割
                    // 否则，dp[i] 通过 dp[j-1] + 1 更新
                    dp[i] = j == 0 ? 0 : Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        return dp[s.length() - 1];
    }

    public static void main(String[] args) {

        String s = "aab";

        System.out.println(minCut(s));

    }
}
