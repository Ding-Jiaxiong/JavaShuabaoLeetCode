package DynamicProgramming_4.PresentBriefly_2.计数问题.隐晦的递推关系.不同的子序列II;

public class Main {

    public static int distinctSubseqII(String s) {

        // 取余常数
        int MOD = 1000000007;

        int[] dp = new int[s.length() + 1];  // dp[i] 表示以 s[i] 结尾的不同非空子序列的个数

        dp[0] = 1;  // 空字符串

        int[] last = new int[26];  // 字符上次出现的位置

        for (int i = 0; i < 26; i++) {
            last[i] = -1;  // 未出现
        }

        // 遍历每一个字符
        for (int i = 1; i <= s.length(); i++) {

            // 当前字符能生成的新子序列的个数
            dp[i] = (2 * dp[i - 1]) % MOD;

            // 当前字符
            char c = s.charAt(i - 1);
            int cIndex = c - 'a';

            // 如果该字符之前出现过，则减去上次出现时带来的重复子序列数
            if (last[cIndex] != -1) {
                dp[i] = (dp[i] - dp[last[cIndex] - 1] + MOD) % MOD;
            }

            // 更新
            last[cIndex] = i;
        }

        return (dp[s.length()] - 1 + MOD) % MOD;  // 减去空
    }

    public static void main(String[] args) {

        String s = "abc";

        System.out.println(distinctSubseqII(s));

    }
}
