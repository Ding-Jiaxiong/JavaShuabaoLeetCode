package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_股票系列_dp_i_k_state_i是时间_k是次数_state是状态.买卖股票的最佳时机IV;

public class Main {

    public static int maxProfit(int k, int[] prices) {

        int n = prices.length;

        if (k >= n / 2) {  // 相当于可以随意交易

            int maxProfit = 0;

            for (int i = 1; i < n; i++) {

                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];  // 只要有利润，就进行买卖
                }
            }

            return maxProfit;
        }

        int[][] dp = new int[k + 1][n];  // dp[k][i] 表示在第 i 天结束时，最多完成 k 次交易所能获得的最大利润

        for (int i = 1; i <= k; i++) {

            int tmpMax = -prices[0];

            for (int j = 1; j < n; j++) {

                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);  // 第 i 次交易的最大利润

                tmpMax = Math.max(tmpMax, dp[i - 1][j] - prices[j]);  // 更新
            }

        }

        return dp[k][n - 1]; // 返回第 n-1 天，最多完成 k 次交易的最大利润
    }

    public static void main(String[] args) {

        int[] prices = {2, 4, 1};

        int k = 2;

        System.out.println(maxProfit(k, prices));

    }
}
