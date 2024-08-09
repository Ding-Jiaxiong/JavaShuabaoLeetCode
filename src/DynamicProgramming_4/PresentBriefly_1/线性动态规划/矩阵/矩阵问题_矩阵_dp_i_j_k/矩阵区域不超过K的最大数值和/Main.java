package DynamicProgramming_4.PresentBriefly_1.线性动态规划.矩阵.矩阵问题_矩阵_dp_i_j_k.矩阵区域不超过K的最大数值和;

public class Main {

    public static int maxSumSubmatrix(int[][] matrix, int k) {

        // 困难题
        int rows = matrix.length; // 矩阵行数
        int cols = matrix[0].length; // 矩阵列数

        int[][] dp = new int[rows + 1][cols + 1];  // dp[i][j] 表示以 matrix[i][j] 为右下角的矩阵的元素和【二维前缀和】

        // 计算二维前缀和
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {

                // 当前点的值等于上方、左方以及减去左上方的值，加上当前矩阵中的值
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int maxSum = Integer.MIN_VALUE;

        // 遍历所有的可能的子矩形
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {

                for (int r = i; r <= rows; r++) {

                    for (int c = j; c <= cols; c++) {

                        // 子矩形的元素和
                        int curSum = dp[r][c] - dp[i - 1][c] - dp[r][j - 1] + dp[i - 1][j - 1];

                        // 检查是否超过 K, 更新最大和
                        if (curSum <= k){
                            maxSum = Math.max(maxSum, curSum);
                        }
                    }
                }
            }
        }


        return maxSum;
    }


    public static void main(String[] args) {

        int[][] matrix = {{1, 0, 1}, {0, -2, 3}};
        int k = 2;

        System.out.println(maxSumSubmatrix(matrix, k));

    }
}
