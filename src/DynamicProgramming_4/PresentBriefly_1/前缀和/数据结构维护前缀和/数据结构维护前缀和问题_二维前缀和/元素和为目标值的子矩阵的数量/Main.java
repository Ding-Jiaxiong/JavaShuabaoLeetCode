package DynamicProgramming_4.PresentBriefly_1.前缀和.数据结构维护前缀和.数据结构维护前缀和问题_二维前缀和.元素和为目标值的子矩阵的数量;

public class Main {

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {

        // 二维前缀和简单题
        int rows = matrix.length;  // 矩阵行数
        int cols = matrix[0].length;  // 矩阵列数

        int[][] prefixSum2d = new int[rows + 1][cols + 1]; // 二维前缀和数组

        int result = 0;  // 满足target 的子矩阵数量初始

        // 计算二维前缀和
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {

                prefixSum2d[i][j] = prefixSum2d[i - 1][j] + prefixSum2d[i][j - 1] - prefixSum2d[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        // 遍历所有子矩阵
        for (int x1 = 1; x1 <= rows; x1++) {

            for (int y1 = 1; y1 <= cols; y1++) {

                for (int x2 = x1; x2 <= rows; x2++) {

                    for (int y2 = y1; y2 <= cols; y2++) {

                        // 子矩阵的和
                        int subMatrixSum = prefixSum2d[x2][y2] - prefixSum2d[x1 - 1][y2] - prefixSum2d[x2][y1 - 1] + prefixSum2d[x1 - 1][y1 - 1];

                        if (subMatrixSum == target) {
                            result++;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};

        int target = 0;


        System.out.println(numSubmatrixSumTarget(matrix, target));

    }
}
