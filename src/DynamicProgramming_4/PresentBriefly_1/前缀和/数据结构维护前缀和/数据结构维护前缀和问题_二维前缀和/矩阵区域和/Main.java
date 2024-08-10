package DynamicProgramming_4.PresentBriefly_1.前缀和.数据结构维护前缀和.数据结构维护前缀和问题_二维前缀和.矩阵区域和;

public class Main {

    public static int[][] matrixBlockSum(int[][] mat, int k) {

        int rows = mat.length;  // 矩阵行数
        int cols = mat[0].length;  // 矩阵列数

        int[][] prefixSum = new int[rows + 1][cols + 1];  // 二维前缀和数组

        int[][] ans = new int[rows][cols];  // 结果矩阵

        // 计算二维前缀和
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {

                prefixSum[i][j] = mat[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        // 计算ans
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // 子矩阵的边界
                int r1 = Math.max(0, i - k);  // 上
                int c1 = Math.max(0, j - k);  // 左

                int r2 = Math.min(rows - 1, i + k);  // 下
                int c2 = Math.min(cols - 1, j + k);  // 右

                // 计算子矩阵和
                ans[i][j] = prefixSum[r2 + 1][c2 + 1] - prefixSum[r1][c2 + 1] - prefixSum[r2 + 1][c1] + prefixSum[r1][c1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int k = 1;

        for (int[] ints : matrixBlockSum(mat, k)) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }
}
