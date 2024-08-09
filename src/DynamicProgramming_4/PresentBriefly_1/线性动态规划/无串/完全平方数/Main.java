package DynamicProgramming_4.PresentBriefly_1.线性动态规划.无串.完全平方数;

import java.util.Arrays;

public class Main {

    public static int numSquares(int n) {

        int[] dp = new int[n + 1];  // dp[i] 表示数字 i 可以由完全平方数相加得到的个数最小值

        Arrays.fill(dp, Integer.MAX_VALUE);  // 初始成一个较大值

        dp[0] = 0;  // 0 由 0 个

        for (int i = 1; i <= n; i++) {

            for (int j = i * i; j <= n; j++) {

                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }

        // dp[n]存储了n可以由多少个完全平方数相加得到的最小值
        return dp[n];

    }


    public static void main(String[] args) {

        int n = 12;

        System.out.println(numSquares(n));
    }
}
