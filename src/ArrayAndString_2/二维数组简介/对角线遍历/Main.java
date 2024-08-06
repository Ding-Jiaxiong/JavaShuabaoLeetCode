package ArrayAndString_2.二维数组简介.对角线遍历;

public class Main {

    public static int[] findDiagonalOrder(int[][] mat) {

        // 特判
        if (mat.length == 0) return new int[0];

        int m = mat.length;
        int n = mat[0].length;

        // 结果数组
        int[] res = new int[m * n];

        int count = m + n - 1;  // 真是, 需要走的次数

        int row = 0;
        int col = 0;
        int index = 0;

        for (int i = 0; i < count; i++) { // 一共要走这么多条线

            // 偶数往右上走，奇数往左下走
            if (i % 2 == 0) {  // 右上

                while (row >= 0 && col < n) {

                    res[index] = mat[row][col];
                    index++;

                    // 右上规律：行减一、列加一
                    row--;
                    col++;
                }

                // 判断越界情况
                if (col < n) {
                    row++;  // 第一次结束这玩意儿已经越出去了，-1了，要加回来
                } else {
                    row += 2;
                    col--;
                }

            } else {  // 左上

                while (row < m && col >= 0) {

                    res[index] = mat[row][col];

                    index++;

                    row++;
                    col--;
                }

                if (row < m) {
                    col++;

                } else {
                    row--;
                    col += 2;
                }

            }

        }

        return res;
    }

    public static void main(String[] args) {

        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for (int i : findDiagonalOrder(mat)) {
            System.out.print(i + " ");
        }

    }
}
