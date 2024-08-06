package HashTable_3.实际应用_设计键.稀疏矩阵的乘法;

public class Main {

    public static int[][] multiply(int[][] mat1, int[][] mat2) {

        // 数学题
        // m x n 的矩阵乘以 n x n 的结果是 m x n 的
        int m = mat1.length;  // 行数等于第一个矩阵的行数
        int n = mat2[0].length;  // 列数等于第二个矩阵的列数

        int[][] res = new int[m][n];  // 结果

        for (int i = 0; i < mat1.length; i++) {  // 遍历 mat1 的行
            for (int j = 0; j < mat2[0].length; j++) { // 遍历 mat2 的列

                int sum = 0;  // 当前单元格的乘积结果

                for (int k = 0; k < mat1[0].length; k++) {
                    sum += mat1[i][k] * mat2[k][j];
                }

                res[i][j] = sum;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[][] mat1 = {{1, 0, 0}, {-1, 0, 3}};
        int[][] mat2 = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};

        for (int[] ints : multiply(mat1, mat2)) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
