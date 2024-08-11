package DynamicProgramming_4.PresentBriefly_2.背包动态规划.AcWing._01背包问题;

import java.util.Scanner;

public class Main {

    // 有限集合的最值问题

    /*
       DP 问题：1. 状态表示
               2. 状态转移方程
     */

    static int N = 1010;

    static int n, m;  // n 是物品数量，m 为背包容积

    static int[] v;  // 所有体积
    static int[] w;  // 所有价值

    static int[][] dp;  // dp

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        dp = new int[N][N];  // dp 初始化，直接开的最大的

        v = new int[N];
        w = new int[N];

        n = in.nextInt();
        m = in.nextInt();

        for (int i = 1; i <= n; i++) {

            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        // dp 转移方程
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {  // 从前 i 个物品中选出体积为 j 的方案

                dp[i][j] = dp[i - 1][j];

                if (j >= v[i]) {

                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }

        System.out.println(dp[n][m]);

    }
}
