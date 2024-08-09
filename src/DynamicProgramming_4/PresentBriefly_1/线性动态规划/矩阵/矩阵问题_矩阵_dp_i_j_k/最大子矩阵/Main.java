package DynamicProgramming_4.PresentBriefly_1.线性动态规划.矩阵.矩阵问题_矩阵_dp_i_j_k.最大子矩阵;

public class Main {

    public static int[] getMaxMatrix(int[][] matrix) {

        // 困男题
        int m = matrix.length; // 矩阵行数
        int n = matrix[0].length; // 矩阵列数

        int maxMat = Integer.MIN_VALUE;  // 初始最大矩阵和值

        int[] res = new int[4];   // 答案数组

        // 直接遍历

        for (int row1 = 0; row1 < m; row1++) { // 起始行

            int nums[] = new int[n];  // 两行之间的列和

            for (int row2 = row1; row2 < m; row2++) {  // 结束行

                int curMax = 0; // 当前最大子数组和
                int start = -1;  // 当前子数组的开始索引

                for (int i = 0; i < n; i++) {  // 计算列和

                    nums[i] += matrix[row2][i];   // 从 row1 行到 row2 行的列和

                    if (curMax > 0) {  // 当前子数组和为正，继续累加

                        curMax += nums[i];
                    } else { // 否则重新开始

                        curMax = nums[i];
                        start = i;  // 新的子数组开始位置更新
                    }

                    // 更新最大矩阵及坐标
                    if (curMax > maxMat) {
                        maxMat = curMax;

                        res[0] = row1;
                        res[1] = start;
                        res[2] = row2;
                        res[3] = i;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[][] matrix = {{-1, 0}, {0, -1}};

        for (int i : getMaxMatrix(matrix)) {
            System.out.print(i + " ");
        }
    }
}
