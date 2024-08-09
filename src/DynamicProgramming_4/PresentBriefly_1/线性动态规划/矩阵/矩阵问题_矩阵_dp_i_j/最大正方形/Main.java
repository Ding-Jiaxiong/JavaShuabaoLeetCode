package DynamicProgramming_4.PresentBriefly_1.线性动态规划.矩阵.矩阵问题_矩阵_dp_i_j.最大正方形;

public class Main {

    public static int maximalSquare(char[][] matrix) {

        int rows = matrix.length; // 矩阵行数
        int cols = matrix[0].length; // 矩阵列数

        int maxSize = 0; // 最大正方形边长

        int[][] dp = new int[rows][cols];  // dp[i][j] 表示以(i,j)为右下角的最大正方形的边长

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '1') {  // 当前位置是 1

                    if (i == 0 || j == 0) {
                        // 在第一行或者第一列，最大边长只能是1
                        dp[i][j] = 1;
                    } else {

                        // 计算当前点为右下角的最大正方形的边长
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }

                    // 更新边长
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }


        return maxSize * maxSize;

    }

    public static void main(String[] args) {

        char[][] matrix = {{'0', '1'}, {'1', '0'}};

        System.out.println(maximalSquare(matrix));
    }
}
