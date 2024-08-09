package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_带维度单串dp_ik_i是位置_k是附加的维度.给房子涂色III;

import java.util.Arrays;

public class Main {

    public static int minCost(int[] houses, int[][] cost, int m, int n, int target) {

        // 困男题
        final int INF = Integer.MAX_VALUE / 2;  // 一个无法达到的极大值

        int[][][] dp = new int[m][target + 1][n];  // dp[i][j][k] 表示将前 i 个房子涂色，使其形成 j 个街区，且第 i 个房子的颜色为 k+1 的最小花费

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < target + 1; j++) {

                Arrays.fill(dp[i][j], INF);  // 初始化
            }
        }

        if (houses[0] != 0) {  // 第一个房子已经有颜色
            dp[0][1][houses[0] - 1] = 0;  // 无花费
        } else {

            // 第一个房子没有颜色, 尝试所有颜色，计算花费
            for (int j = 0; j < n; j++) {
                dp[0][1][j] = cost[0][j];
            }
        }

        // 遍历每一个房子
        for (int i = 1; i < m; i++) {

            // 当前房子已经涂色
            if (houses[i] != 0) {

                int color = houses[i] - 1;

                // 遍历街区
                for (int j = 1; j <= target; j++) {

                    // 上一房子的颜色与当前房子相同，不增加街区
                    dp[i][j][color] = Math.min(dp[i][j][color], dp[i - 1][j][color]);

                    // 上一房子的颜色与当前房子不同，增加一个街区
                    for (int p = 0; p < n; p++) {
                        if (p != color) {
                            dp[i][j][color] = Math.min(dp[i][j][color], dp[i - 1][j - 1][p]);
                        }
                    }
                }

            } else { // 当前房子没有涂色

                for (int j = 1; j <= target; j++) {
                    // 尝试所有颜色
                    for (int color = 0; color < n; color++) {
                        // 上一房子的颜色与当前房子相同，不增加街区
                        dp[i][j][color] = Math.min(dp[i][j][color], dp[i - 1][j][color] + cost[i][color]);

                        // 上一房子的颜色与当前房子不同，增加一个街区
                        for (int p = 0; p < n; p++) {
                            if (p != color) {
                                dp[i][j][color] = Math.min(dp[i][j][color], dp[i - 1][j - 1][p] + cost[i][color]);
                            }
                        }
                    }
                }
            }

        }

        // 最后一个房子的最小花费，目标是形成 target 个街区
        int minCost = INF;

        for (int color = 0; color < n; color++) {
            minCost = Math.min(minCost, dp[m - 1][target][color]);
        }

        return minCost == INF ? -1 : minCost;

    }

    public static void main(String[] args) {

        int[] houses = {0, 0, 0, 0, 0};

        int[][] cost = {{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}};

        int m = 5;
        int n = 2;

        int target = 3;

        System.out.println(minCost(houses, cost, m, n, target));

    }
}
