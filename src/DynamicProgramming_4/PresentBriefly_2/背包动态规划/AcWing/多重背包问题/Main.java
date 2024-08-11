package DynamicProgramming_4.PresentBriefly_2.背包动态规划.AcWing.多重背包问题;

import java.util.Scanner;

public class Main {

    static int N = 110;

    static int n;
    static int m;

    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[] s = new int[N];

    static int[][] dp = new int[N][N];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        for (int i = 1; i <= n; i++) {

            v[i] = in.nextInt();
            w[i] = in.nextInt();
            s[i] = in.nextInt();
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                for (int k = 0; k <= s[i]; k++) {

                    if (j >= k * v[i]) {

                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i]] + k * w[i]);
                    }
                }
            }
        }

        System.out.println(dp[n][m]);

    }
}
