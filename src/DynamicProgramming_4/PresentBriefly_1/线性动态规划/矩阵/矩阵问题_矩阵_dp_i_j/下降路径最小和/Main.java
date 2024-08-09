package DynamicProgramming_4.PresentBriefly_1.线性动态规划.矩阵.矩阵问题_矩阵_dp_i_j.下降路径最小和;

public class Main {

    public static int minFallingPathSum(int[][] matrix) {

        int n = matrix.length; // 矩阵行数

        // 遍历每一行，从第二行开始
        for (int row = 1; row < n; row++) {

            for (int col = 0; col < n; col++) {

                // 从上一行的三个可能位置中选取最小值
                int bestAbove = matrix[row - 1][col];  // 正上方

                if (col > 0) {  // 左上方元素是否存在
                    bestAbove = Math.min(bestAbove, matrix[row - 1][col - 1]);
                }
                if (col < n - 1) { // 右上方元素是否存在
                    bestAbove = Math.min(bestAbove, matrix[row - 1][col + 1]);
                }

                // 更新
                matrix[row][col] += bestAbove;
            }
        }

        // 找到最后一行的最小返回
        int minSum = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, matrix[n - 1][col]);  // 看最后一行的每一列
        }

        return minSum;
    }


    public static void main(String[] args) {

        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};

        System.out.println(minFallingPathSum(matrix));
    }
}
