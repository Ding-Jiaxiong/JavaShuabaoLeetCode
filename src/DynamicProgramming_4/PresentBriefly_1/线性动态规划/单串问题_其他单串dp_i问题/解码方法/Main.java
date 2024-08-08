package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串问题_其他单串dp_i问题.解码方法;

public class Main {

    public static int numDecodings(String s) {

        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length()];  // dp[i] 表示以 s[i] 字符结尾的子字符串可以解码种类数

        dp[0] = 1;  // 一个字符( 不是0 )的时候只会有唯一的解

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) != '0') {
                dp[i] = dp[i - 1];  // 当前字符不是 0, 它可以单独解码，先继承下来前一个的解码数
            }

            // 计算当前字符和前一个字符组成的两位数
            int number = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');

            // 如果这个两位数在 10到26 之间，它可以解码为一个字母
            if (number >= 10 && number <= 26) {
                if (i >= 2) {
                    // 如果i大于等于2，dp[i]还需要加上dp[i-2]的解码方法数
                    dp[i] += dp[i - 2];
                } else {
                    // 如果i小于2，dp[i]直接加1，dp[i-2]越界
                    dp[i] += 1;
                }
            }

        }

        return dp[s.length() - 1];
    }


    public static void main(String[] args) {

        String s = "12";

        System.out.println(numDecodings(s));

    }
}
