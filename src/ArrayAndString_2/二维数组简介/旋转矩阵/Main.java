package ArrayAndString_2.二维数组简介.旋转矩阵;

public class Main {

    public static void rotate(int[][] matrix) {

        // K 神大法
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {

            for (int j = 0; j < (n + 1) / 2; j++) {

                int tmp = matrix[i][j];

                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;

            }

        }

    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        rotate(matrix);

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }
}
