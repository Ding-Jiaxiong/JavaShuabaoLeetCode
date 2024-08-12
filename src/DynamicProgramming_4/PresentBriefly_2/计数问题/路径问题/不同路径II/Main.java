package DynamicProgramming_4.PresentBriefly_2.计数问题.路径问题.不同路径II;

public class Main {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;  // 行数
        int n = obstacleGrid[0].length; // 列数

        // 如果起点或终点有障碍物，直接返回0，因为无法到达终点
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];  // dp[i][j] 表示从起点到达位置 (i, j) 的路径数

        // 起点
        dp[0][0] = 1;

        // 初始化第一行
        for (int i = 1; i < m; i++) {

            // 如果当前位置没有障碍物，并且上一行的路径数不是0，则当前路径数为1，否则为0
            dp[i][0] = (obstacleGrid[i][0] == 1) ? 0 : dp[i - 1][0];
        }

        // 初始化第一列
        for (int i = 1; i < n; i++) {
            // 如果当前位置没有障碍物，并且上一列的路径数不是0，则当前路径数为1，否则为0
            dp[0][i] = (obstacleGrid[0][i] == 1) ? 0 : dp[0][i - 1];
        }

        // 计算其他位置
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                // 如果当前位置是障碍物
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];  //  当前路径数等于从上方和左方到达的路径数之和
            }
        }

        return dp[m - 1][n - 1];

    }

    public static void main(String[] args) {

        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        System.out.println(uniquePathsWithObstacles(obstacleGrid));

    }
}
