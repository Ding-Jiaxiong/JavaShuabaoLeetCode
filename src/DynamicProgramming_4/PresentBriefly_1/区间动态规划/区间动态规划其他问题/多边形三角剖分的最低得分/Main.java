package DynamicProgramming_4.PresentBriefly_1.区间动态规划.区间动态规划其他问题.多边形三角剖分的最低得分;

public class Main {

    public static int minScoreTriangulation(int[] values) {

        int n = values.length;  // 顶点数量

        int[][] dp = new int[n][n];  // dp[i][j] 表示从顶点 i 到顶点 j 之间的最小三角剖分分数

        // 遍历所有长度为 k 的区间
        for (int len = 2; len < n; len++) {

            for (int i = 0; i < n - len; i++) {

                int j = i + len;

                dp[i][j] = Integer.MAX_VALUE;  // 初始化为最大值

                // 遍历所有可能的 k，使得 i < k < j
                for (int k = i + 1; k < j; k++) {

                    // 计算当前三角形的分数
                    int score = values[i] * values[k] * values[j];

                    // 更新
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + score);
                }
            }
        }

        // 从顶点 0 到顶点 n-1 的最小三角剖分分数
        return dp[0][n - 1];
    }

    public static void main(String[] args) {

        int[] values = {1, 2, 3};

        System.out.println(minScoreTriangulation(values));

    }
}
