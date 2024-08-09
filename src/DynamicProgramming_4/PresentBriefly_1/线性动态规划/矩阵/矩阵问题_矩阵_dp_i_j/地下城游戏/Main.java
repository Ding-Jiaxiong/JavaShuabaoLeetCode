package DynamicProgramming_4.PresentBriefly_1.线性动态规划.矩阵.矩阵问题_矩阵_dp_i_j.地下城游戏;

public class Main {

    public static int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n]; // dp[i][j] 表示骑士在位置 (i, j) 处所需的最小初始健康点数

        // 从右下角倒推
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);

        // 最后一列, 只能往上看
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);  // 需要的健康点数
        }

        // 最后一行，只能往左看
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = Math.max(1, dp[m - 1][i + 1] - dungeon[m - 1][i]); // 计算需要的健康点数
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {

                // 从右边或下边的最小健康点数中选取最小值
                int minHealth = Math.min(dp[i + 1][j], dp[i][j + 1]);

                dp[i][j] = Math.max(1, minHealth - dungeon[i][j]);
            }
        }

        // 从左上角开始的最小初始健康点数
        return dp[0][0];
    }

    public static void main(String[] args) {

        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};

        System.out.println(calculateMinimumHP(dungeon));

    }
}
