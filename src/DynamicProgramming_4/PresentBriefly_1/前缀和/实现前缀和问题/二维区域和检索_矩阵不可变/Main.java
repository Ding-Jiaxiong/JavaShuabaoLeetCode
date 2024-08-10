package DynamicProgramming_4.PresentBriefly_1.前缀和.实现前缀和问题.二维区域和检索_矩阵不可变;

public class Main {

    // 二维前缀和
    static class NumMatrix {

        int[][] sums;  // sums[i][j] 表示从矩阵左上角 (0, 0) 到 (i , j) 这一块矩形区域内所有元素的和

        public NumMatrix(int[][] matrix) {

            int m = matrix.length;  // 矩阵行数
            int n = matrix[0].length; // 矩阵列数

            sums = new int[m + 1][n + 1];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    // 上方区域的前缀和 + 左边区域前缀和 - 上方和左方重叠的(加了两次) + 当前元素的值
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            /*
                sums[row2 + 1][col2 + 1]：从 (0, 0) 到 (row2, col2) 的前缀和
                sums[row1][col2 + 1]：减去上方多出的部分
                sums[row2 + 1][col1]：减去左边多出的部分
                sums[row1][col1]：加回被两次减去的左上角重叠部分
             */

            return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
        }
    }

    public static void main(String[] args) {

        NumMatrix numMatrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});

        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));

    }
}
