package ArrayAndString_2.字符串简介.最长回文子串;

import java.util.Arrays;

public class Main {


    // 动态规划【二维】
    public static String longestPalindrome(String s) {

        int len = s.length();

        if (len < 2) return s;  // 其实就是 1 那种情况, 返回自身

        int maxLen = 1;  // 最大长度，默认为 1， 最坏情况也能有一个长度为 1 的字符串是回文串
        int begin = 0; // 默认最大长度对应的子串是索引 0 开始的, 就开头那个字符

        boolean[][] dp = new boolean[len][len];  // dp[i,j] 表示 s[i..j] 是否是回文串

        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;  // 初始状态，从i到i，长度为1的子串都是回文串
        }

        for (int j = 1; j < len; j++) {  // 从第二个字符开始看

            for (int i = 0; i < j; i++) {

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;   // 以 [i, j] 这一截不是回文的
                } else {

                    if (j - i < 3) dp[i][j] = true; // 在 i，j 已经相等的情况，长度 < 3 说明是回文的
                    else dp[i][j] = dp[i + 1][j - 1];  // 去掉左右两个一个字符，看剩下的子串还是否是回文的
                }

                // 记录状态
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }

            }
        }

        return s.substring(begin, begin + maxLen);  // 返回子串

    }

    public static void main(String[] args) {

        String s = "babad";

        System.out.println(longestPalindrome(s));

    }

}
