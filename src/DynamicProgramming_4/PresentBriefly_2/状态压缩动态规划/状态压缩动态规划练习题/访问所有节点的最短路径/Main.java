package DynamicProgramming_4.PresentBriefly_2.状态压缩动态规划.状态压缩动态规划练习题.访问所有节点的最短路径;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static int shortestPathLength(int[][] graph) {

        int n = graph.length;

        int[][] dp = new int[1 << n][n];  // dp[mask][i]表示当前状态为mask时，最后到达节点i的最短路径长度

        // 记录每个状态是否被访问过
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }

        // 初始化队列，BFS
        Queue<int[]> queue = new LinkedList<>();

        // 初始化状态
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{1 << i, i});
            dp[1 << i][i] = 0;
        }

        // BFS
        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int mask = curr[0], u = curr[1];

            int step = dp[mask][u];

            // 遍历与当前节点相邻的节点
            for (int v : graph[u]) {

                int nextMask = mask | (1 << v); // 更新

                // 如果通过节点v得到的路径更短，更新路径长度并将其加入队列
                if (dp[nextMask][v] > step + 1) {
                    dp[nextMask][v] = step + 1;
                    queue.add(new int[]{nextMask, v});
                }
            }
        }

        // 找到到达所有节点的最短路径
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minLength = Math.min(minLength, dp[(1 << n) - 1][i]);
        }

        return minLength;
    }

    public static void main(String[] args) {

        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};

        System.out.println(shortestPathLength(graph));

    }
}
