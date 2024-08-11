package DynamicProgramming_4.PresentBriefly_2.状态压缩动态规划.状态压缩动态规划练习题.安卓系统手势解锁;

public class Main {

    static int[][] skip = new int[10][10]; // 中间点矩阵

    public static int numberOfPatterns(int m, int n) {

        // 初始化数组记录各点之间的跳跃关系
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;

        // visited数组记录各个点是否已经访问
        boolean[] visited = new boolean[10];

        int res = 0;

        // 计算在m到n个点之间的所有有效模式
        for (int i = m; i <= n; i++) {

            // 每个点开始的所有模式
            res += dfs(visited, skip, 1, i - 1) * 4;  // 点1,3,7,9是对称的，结果乘以4
            res += dfs(visited, skip, 2, i - 1) * 4;  // 点2,4,6,8是对称的，结果乘以4
            res += dfs(visited, skip, 5, i - 1);  // 独立计算
        }

        return res;
    }

    private static int dfs(boolean[] visited, int[][] skip, int cur, int remain) {

        if (remain < 0) return 0;  // 剩余点数小于0，返回0
        if (remain == 0) return 1;  // 剩余点数为0，找到一个有效模式，返回1

        visited[cur] = true;  // 当前点标记

        int res = 0;

        // 遍历所有可能的下一个点
        for (int next = 1; next <= 9; next++) {

            // 如果下一个点未被访问，且中间点已经被访问或两点之间没有中间点
            if (!visited[next] && (skip[cur][next] == 0 || visited[skip[cur][next]])) {

                res += dfs(visited, skip, next, remain - 1); // 递归搜索剩余点
            }
        }

        visited[cur] = false;  // 回溯

        return res;
    }


    public static void main(String[] args) {

        int m = 1;
        int n = 1;

        System.out.println(numberOfPatterns(m, n));
    }
}
