package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_带维度单串dp_ik_i是位置_k是附加的维度.粉刷房子;

public class Main {

    public static int minCost(int[][] costs) {

        // 简单dp
        int n = costs.length;

        int[][] dp = new int[n + 5][3];  // dp[i][j] 表示刷到第 i 所房子粉刷 j 色的最小总花费 【多开防止越界】

        for (int i = 1; i <= n; i++) {

            // 对于 第 i 个房子， 计算粉刷成每种颜色时的最小花费
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0];  // 红色 【前一个房子刷成绿色或者蓝色】
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i - 1][1];  // 绿色 【前一个 ...】
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i - 1][2];  // 蓝色 【...】

        }

        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));

    }

    public static void main(String[] args) {

        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};

        System.out.println(minCost(costs));

    }
}
