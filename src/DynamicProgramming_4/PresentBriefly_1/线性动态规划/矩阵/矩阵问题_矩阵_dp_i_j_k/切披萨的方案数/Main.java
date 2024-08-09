package DynamicProgramming_4.PresentBriefly_1.线性动态规划.矩阵.矩阵问题_矩阵_dp_i_j_k.切披萨的方案数;

public class Main {

    // 取余模数
    private static final int MOD = 1_000_000_007;

    public static int ways(String[] pizza, int k) {

        int rows = pizza.length;
        int cols = pizza[0].length();

        int[][][] dp = new int[rows + 1][cols + 1][k + 1]; // dp[i][j][k] 表示从(i, j)出发切成k块的方案数

        int[][] apples = new int[rows + 1][cols + 1];  // apples[i][j]表示从(i, j)到右下角的矩形中有多少个苹果

        // 从右下角开始统计苹果数量
        for (int i = rows - 1; i >= 0; i--) {

            for (int j = cols - 1; j >= 0; j--) {

                apples[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0) + apples[i + 1][j] + apples[i][j + 1] - apples[i + 1][j + 1];

                // 从(i, j)出发只切成一块的情况
                dp[i][j][1] = apples[i][j] > 0 ? 1 : 0;
            }
        }

        // 从2块到k块填充 dp
        for (int count = 2; count <= k; count++) {

            for (int i = 0; i < rows; i++) {

                for (int j = 0; j < cols; j++) {

                    dp[i][j][count] = 0;

                    // 水平切
                    for (int x = i + 1; x < rows; x++) {

                        // 如果上半部分有苹果
                        if (apples[i][j] - apples[x][j] > 0) {
                            dp[i][j][count] = (dp[i][j][count] + dp[x][j][count - 1]) % MOD;
                        }
                    }

                    // 垂直切
                    for (int y = j + 1; y < cols; y++) {

                        // 如果左半部分有苹果
                        if (apples[i][j] - apples[i][y] > 0) {
                            dp[i][j][count] = (dp[i][j][count] + dp[i][y][count - 1]) % MOD;
                        }
                    }
                }
            }

        }

        // 从(0, 0)出发切成k块的方案数
        return dp[0][0][k];

    }

    public static void main(String[] args) {

        String[] pizza = {"A..", "AAA", "..."};

        int k = 3;

        System.out.println(ways(pizza, k));
    }
}
