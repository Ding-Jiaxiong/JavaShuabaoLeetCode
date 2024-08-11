package DynamicProgramming_4.PresentBriefly_2.背包动态规划.AcWing.完全背包问题;

import java.util.Scanner;

public class Main {

    static int N = 1001;

    static int n, m;  // 物品数量和背包容积

    static int[] v;  // 体积数组
    static int[] w;  // 价值数组

    static int[][] dp;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        v = new int[N];
        w = new int[N];

        dp = new int[N][N];

        n = in.nextInt();
        m = in.nextInt();

        for (int i = 1; i <= n; i++) {

            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        in.close();

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                dp[i][j] = dp[i - 1][j];

                if (j >= v[i]) {

                    // 和 01 背包的区别就是状态转移方程，完全背包每种物品有无限个
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - v[i]] + w[i]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
