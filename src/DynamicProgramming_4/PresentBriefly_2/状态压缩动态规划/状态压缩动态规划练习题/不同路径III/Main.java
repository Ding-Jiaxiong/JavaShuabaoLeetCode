package DynamicProgramming_4.PresentBriefly_2.状态压缩动态规划.状态压缩动态规划练习题.不同路径III;

public class Main {

    // 移动坐标
    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};

    private static int totalPaths = 0;

    public static int uniquePathsIII(int[][] grid) {

        totalPaths = 0;

        int startRow = 0;
        int startCol = 0;  // 起始点

        int emptySquares = 0;  // 记录可以通过的空方格数量

        // 遍历 grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                } else if (grid[i][j] == 0) {

                    emptySquares++;
                }
            }
        }

        // 从起点开始 dfs
        dfs(grid, startRow, startCol, emptySquares);

        return totalPaths;

    }

    private static void dfs(int[][] grid, int row, int col, int emptySquares) {

        // 特判
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1) {
            return;
        }

        // 遇到终点
        if (grid[row][col] == 2) {
            // 只有当所有空方格都经过时，才算作一条有效路径
            if (emptySquares == -1) {
                totalPaths++;
            }

            return;
        }

        // 将当前方格标记为已访问
        grid[row][col] = -1;

        // 递归访问四个方向的相邻方格
        for (int i = 0; i < 4; i++) {
            dfs(grid, row + dRow[i], col + dCol[i], emptySquares - 1);
        }

        // 回溯
        grid[row][col] = 0;
    }

    public static void main(String[] args) {

        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};

        System.out.println(uniquePathsIII(grid));
    }
}
