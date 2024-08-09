package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_最大子数组和系列.矩形区域不超过K的最大数值和;

public class Main {

    public static int maxSumSubmatrix(int[][] matrix, int k) {

        // 困难题
        int m = matrix.length; // 矩阵行数
        int n = matrix[0].length;  // 矩阵列数

        // 二维前缀和
        int[][] sum = new int[m + 1][n + 1];   // 前缀和矩阵，sun[i][j] 表示从左上角到 [i][j] 点的矩阵元素和

        // 计算二维前缀和
        for (int i = 1; i <= m; i++) {  // 多开，不会越界
            for (int j = 1; j <= n; j++) {

                // 当前点的值等于上方、左方以及减去左上方的值，加上当前矩阵中的值
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int ans = Integer.MIN_VALUE;   // 初始化最大值为一个非常小的数

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                for (int p = i; p <= m; p++) {
                    for (int q = j; q <= n; q++) {

                        int cur = sum[p][q] - sum[i - 1][q] - sum[p][j - 1] + sum[i - 1][j - 1];  // 从 (i, j) 点到 (p, q) 之间的子矩阵的元素和

                        if (cur <= k) {
                            // 更新
                            ans = Math.max(ans, cur);
                        }
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 0, 1}, {0, -2, 3}};
        int k = 2;

        System.out.println(maxSumSubmatrix(matrix, k));
    }
}
