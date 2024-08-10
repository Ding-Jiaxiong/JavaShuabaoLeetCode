package DynamicProgramming_4.PresentBriefly_1.前缀和.数据结构维护前缀和.数据结构维护前缀和问题_二维前缀和.矩阵区域不超过K的最大数值和;

public class Main {

    public static int maxSumSubmatrix(int[][] matrix, int k) {

        // 又是这个题【动态规划做了】
        int rows = matrix.length;  // 矩阵行数
        int cols = matrix[0].length; // 矩阵列数

        int[][] prefixSum2d = new int[rows + 1][cols + 1];  // 二维前缀和数组

        // 计算二维前缀和
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {

                prefixSum2d[i][j] = prefixSum2d[i - 1][j] + prefixSum2d[i][j - 1] - prefixSum2d[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int maxSum = Integer.MIN_VALUE;

        // 遍历所有可能的子矩阵
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {

                for (int r = i; r <= rows; r++) {

                    for (int c = j; c <= cols; c++) {

                        // 子矩阵元素和
                        int curSum = prefixSum2d[r][c] - prefixSum2d[i - 1][c] - prefixSum2d[r][j - 1] + prefixSum2d[i - 1][j - 1];

                        if (curSum <= k) {
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
