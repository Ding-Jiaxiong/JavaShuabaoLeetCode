package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_其他单串dp_i问题.最长有效括号;

public class Main {

    public static int longestValidParentheses(String s) {

        int maxres = 0;  // 结果，最长有效括号长度

        int[] dp = new int[s.length()];  // dp[i] 表示以 s[i] 字符结尾的最长有效括号子串的长度

        for (int i = 1; i < s.length(); i++) {  // s[0] 不可能形成

            if (s.charAt(i) == ')') {  // 当前是 )

                if (s.charAt(i - 1) == '(') {  // 前一个是 (，这个位置就形成了一对有效括号
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2; // 在前面的有效括号长度上加上当前这对新的括号

                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {  // 如果当前字符的前一个有效括号子串之前有一个左括号 (，并且 i - dp[i - 1] > 0（确保不越界），则此括号与之前的有效括号组合形成更长的有效括号

                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;  // 计算新的 dp[i] 值
                }

                maxres = Math.max(maxres, dp[i]);
            }
        }

        return maxres;

    }

    public static void main(String[] args) {

        String s = "(()";

        System.out.println(longestValidParentheses(s));
    }
}
