package DynamicProgramming_4.PresentBriefly_1.前缀和.数据结构维护前缀和.数据结构维护前缀和问题_二维前缀和.最大子矩阵;

public class Main {

    public static int[] getMaxMatrix(int[][] matrix) {

        int rows = matrix.length;  // 矩阵行数
        int cols = matrix[0].length;  // 矩阵列数

        int[][] prefixSum2d = new int[rows + 1][cols + 1];  // 二维前缀和数组

        // 计算二维前缀和
        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= cols; j++) {

                prefixSum2d[i][j] = matrix[i - 1][j - 1] + prefixSum2d[i - 1][j] + prefixSum2d[i][j - 1] - prefixSum2d[i - 1][j - 1];
            }
        }

        int maxSum = Integer.MIN_VALUE;   // 初始化最大和

        int[] result = new int[4];  // 结果坐标

        // 遍历所有子矩阵
        for (int r1 = 0; r1 < rows; r1++) {

            for (int c1 = 0; c1 < cols; c1++) {

                for (int r2 = r1; r2 < rows; r2++) {

                    for (int c2 = c1; c2 < cols; c2++) {

                        // 子矩阵的和
                        int subMatrixSum = prefixSum2d[r2 + 1][c2 + 1] - prefixSum2d[r1][c2 + 1] - prefixSum2d[r2 + 1][c1] + prefixSum2d[r1][c1];

                        // 更新最大和
                        if (subMatrixSum > maxSum) {

                            maxSum = subMatrixSum;

                            result[0] = r1; // 上
                            result[1] = c1; // 左

                            result[2] = r2;  // 下
                            result[3] = c2;  // 右
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix = {{-1, 0}, {0, -1}};

        for (int maxMatrix : getMaxMatrix(matrix)) {
            System.out.print(maxMatrix + " ");
        }

    }
}
