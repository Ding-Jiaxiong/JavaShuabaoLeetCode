package DynamicProgramming_4.PresentBriefly_1.线性动态规划.矩阵.矩阵问题_矩阵_dp_i_j.最小路径和;

public class Main {

    public static int minPathSum(int[][] grid) {

        int m = grid.length; // 行数
        int n = grid[0].length; // 列数

        int[][] dp = new int[m][n];  // dp[i][j] 表示 从[0][0] 点到达 [i][j] 点位置的最小路径和

        // 初始化
        dp[0][0] = grid[0][0];  // 不动

        // 第一行，只能往右走
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // 第一列，只能往下走
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                // 到达grid[i][j]的路径只能从左边或者上边来，选择路径和较小的
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // 到达右下角的最小路径和
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        System.out.println(minPathSum(grid));

    }
}
