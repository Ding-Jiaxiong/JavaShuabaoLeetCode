package DynamicProgramming_4.PresentBriefly_1.线性动态规划.矩阵.矩阵问题_矩阵_dp_i_j_k.最大矩形;

public class Main {

    public static int maximalRectangle(char[][] matrix) {

        // 和最大正方形有一腿【不过这里要分宽高来考虑】
        int rows = matrix.length; // 矩阵行数
        int cols = matrix[0].length;  // 矩阵列数

        int[][] dp = new int[rows][cols];  // dp[i][j] 表示以 matrix[i][j] 为右边界的最大矩形的宽度，即从当前位置向左延伸的连续 '1' 的数量

        int maxArea = 0;

        // 直接遍历
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '1') {

                    // 计算左边
                    dp[i][j] = (j == 0) ? 1 : dp[i][j - 1] + 1;

                    int minWidth = dp[i][j];

                    // 从当前元素向上看，最大矩形面积
                    for (int k = i; k >= 0; k--) {

                        minWidth = Math.min(minWidth, dp[k][j]);
                        int height = i - k + 1;

                        maxArea = Math.max(maxArea, minWidth * height);
                    }
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(maximalRectangle(matrix));

    }
}
