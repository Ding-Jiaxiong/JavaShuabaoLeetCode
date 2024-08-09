package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_带维度单串dp_ik_i是位置_k是附加的维度.粉刷房子II;

public class Main {

    public static int minCostII(int[][] costs) {

        // 和 I 很像，不过 I 是定死了有 3 种颜色【现在不定数量了，直接升成困难题】
        int n = costs.length;  // 房子数量

        int k = costs[0].length;  // 颜色数量

        int[][] dp = new int[n][k];  // dp[i][j] 表示粉刷到 第 i 个房子，粉刷成 j 色的最小总花费

        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];  // 第一个房子的花费就是对应颜色的花费
        }

        // 从第二个房子开始
        for (int i = 1; i < n; i++) {

            int min1 = Integer.MAX_VALUE; // 最小花费
            int min2 = Integer.MAX_VALUE;  // 次小花费


            // 计算前一个房子
            for (int j = 0; j < k; j++) {

                if (dp[i - 1][j] < min1) {
                    min2 = min1; // 更新次小花费为之前的最小花费
                    min1 = dp[i - 1][j];  // 更新最小花费为当前的 dp[i-1][j]
                } else if (dp[i - 1][j] < min2) {
                    min2 = dp[i - 1][j];  // 更新次小花费
                }
            }

            for (int j = 0; j < k; j++) {
                // 如果当前颜色 j 与前一个房子粉刷的最小花费颜色相同，则选择次小花费，否则选择最小花费
                dp[i][j] = (dp[i - 1][j] == min1 ? min2 : min1) + costs[i][j];
            }
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }

        return res;
    }


    public static void main(String[] args) {

        int[][] costs = {{1, 5, 3}, {2, 9, 4}};

        System.out.println(minCostII(costs));

    }
}
