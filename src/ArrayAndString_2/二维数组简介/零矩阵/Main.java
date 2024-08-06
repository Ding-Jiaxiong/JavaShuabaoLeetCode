package ArrayAndString_2.二维数组简介.零矩阵;

import java.util.HashSet;

public class Main {

    public static void setZeroes(int[][] matrix) {

        HashSet<Integer> row_zero = new HashSet<>(); // 0的行号
        HashSet<Integer> col_zero = new HashSet<>(); // 0的列号

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (matrix[i][j] == 0) {
                    // 加入行号列号
                    row_zero.add(i);
                    col_zero.add(j);
                }

            }
        }

        // 置零操作
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (row_zero.contains(i) || col_zero.contains(j)) matrix[i][j] = 0;

            }
        }
    }

    public static void main(String[] args) {

        int[][] nums = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        setZeroes(nums);

        for (int[] num : nums) {
            for (int i : num) {
                System.out.print(i + " ");
            }

            System.out.println();
        }

    }
}
