package HashTable_3.实际应用_设计键.有效的数独;

public class Main {

    public static boolean isValidSudoku(char[][] board) {

        // 找规律
        // 辅助数组【分别表示某个数字是否已经出现在了某行、某列、或某3x3】
        boolean[][] row = new boolean[10][10];
        boolean[][] col = new boolean[10][10];
        boolean[][] area = new boolean[10][10];

        // 遍历整个 board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {  // 遍历

                int c = board[i][j];   // 自动类型转换
                if (c == '.') continue;

                int u = c - '0';  // 字符转数字，'5' - '0' = 5
                int index = i / 3 * 3 + j / 3; // 标识当前单元格属性哪个 3x3

                if (row[i][u] || col[j][u] || area[index][u]) return false; // 检查

                row[i][u] = col[j][u] = area[index][u] = true; // 标记为出现过

            }
        }

        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board));
    }
}
