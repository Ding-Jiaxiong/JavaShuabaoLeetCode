package DynamicProgramming_4.PresentBriefly_1.线性动态规划.双串.双串问题_带维度双串_dp_i_j_k.扰乱字符串;

public class Main {

    public static boolean isScramble(String s1, String s2) {

        int n = s1.length();
        if (n != s2.length()) {

            return false;
        } else if (n == 1) {
            return s1.charAt(0) == s2.charAt(0);
        } else {

            boolean[][][] dp = new boolean[n][n][n + 1];  // dp[i][j][k] 表示 s1 从 i 开始长度为 k 的子串是否可以变换成 s2 从 j 开始长度为 k 的子串

            // 初始化, k = 1 时，直接比较两个字符是否相等
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
                }
            }

            // 遍历子字符串
            for (int k = 2; k <= n; k++) {

                // s1 的起始位置 i
                for (int i = 0; i <= n - k; i++) {

                    // s2 的起始位置 j
                    for (int j = 0; j <= n - k; j++) {

                        // 分割点
                        for (int p = 1; p < k; p++) {

                            // 是否可以通过不交换子字符串得到扰乱字符串
                            if (dp[i][j][p] && dp[i + p][j + p][k - p]) {

                                dp[i][j][k] = true;
                                break;
                            }

                            // 是否可以通过交换子字符串得到扰乱字符串
                            if (dp[i][j + k - p][p] && dp[i + p][j][k - p]) {

                                dp[i][j][k] = true;
                                break;
                            }
                        }
                    }
                }
            }

            return dp[0][0][n];
        }

    }

    public static void main(String[] args) {

        String s1 = "great", s2 = "rgeat";

        System.out.println(isScramble(s1, s2));
    }
}
