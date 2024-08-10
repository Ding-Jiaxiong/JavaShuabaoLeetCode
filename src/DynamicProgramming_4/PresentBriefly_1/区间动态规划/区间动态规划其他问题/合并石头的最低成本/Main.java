package DynamicProgramming_4.PresentBriefly_1.区间动态规划.区间动态规划其他问题.合并石头的最低成本;

public class Main {

    public static int mergeStones(int[] stones, int k) {

        int n = stones.length;

        if ((n - 1) % (k - 1) != 0) return -1;

        // 前缀和数组
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stones[i];
        }

        int[][][] dp = new int[n][n][k + 1];  // dp[i][j][m] 表示将stones[i..j]合并成m堆的最小成本

        // 初始化
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int m = 2; m <= k; m++) {

                    dp[i][j][m] = Integer.MAX_VALUE;
                }
            }
        }

        // 单堆情况
        for (int i = 0; i < n; i++) {
            dp[i][i][1] = 0;
        }

        // 枚举区间长度
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len - 1 < n; i++) {

                // 区间终点 j
                int j = i + len - 1;

                // 枚举中间分割点 p
                for (int p = i; p < j; p += (k - 1)) {

                    // 更新将 stones[i..j] 合并为 m 堆的最小成本
                    for (int m = 2; m <= k; m++) {

                        dp[i][j][m] = Math.min(dp[i][j][m], dp[i][p][1] + dp[p + 1][j][m - 1]);
                    }
                }

                // 将 m 堆合并为一堆的成本计算
                dp[i][j][1] = dp[i][j][k] + prefixSum[j + 1] - prefixSum[i];
            }
        }

        return dp[0][n - 1][1];
    }

    public static void main(String[] args) {

        int[] stones = {3, 2, 4, 1};
        int k = 2;

        System.out.println(mergeStones(stones, k));
    }
}
