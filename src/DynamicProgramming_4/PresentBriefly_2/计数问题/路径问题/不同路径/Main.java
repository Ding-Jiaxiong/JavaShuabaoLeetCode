package DynamicProgramming_4.PresentBriefly_2.计数问题.路径问题.不同路径;

public class Main {

    public static int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];  //  dp[i][j] 表示从起点到 (i, j) 的路径总数

        // 初始化第一行
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // 初始化第一列
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        // 递推
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                // 当前单元格的路径数等于其左边和上边单元格路径数之和
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        int m = 3;
        int n = 7;

        System.out.println(uniquePaths(m, n));

    }

}
