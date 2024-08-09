package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_股票系列_dp_i_k_state_i是时间_k是次数_state是状态.最佳买卖股票时机含冷冻期;

public class Main {

    public static int maxProfit(int[] prices) {

        int n = prices.length;

        int[] hold = new int[n];  // 持有股票时的最大利润
        int[] sold = new int[n];  // 卖出股票后的最大利润
        int[] rest = new int[n];  // 处于冻结期( 无操作 ) 的最大利润

        // 初始化第一天
        hold[0] = -prices[0]; // 第一天买入
        sold[0] = 0; // 第一天无法卖出
        rest[0] = 0; // 第一天没有操作

        for (int i = 1; i < n; i++) {

            hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i]);  // 要么继续持有，要么今天买入

            // 今天要卖出
            sold[i] = hold[i - 1] + prices[i];

            // 要么是昨天卖出了，要么是继续不变
            rest[i] = Math.max(rest[i - 1], sold[i - 1]);
        }

        // 最后一天肯定得卖出或者无操作
        return Math.max(sold[n - 1], rest[n - 1]);

    }

    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 0, 2};

        System.out.println(maxProfit(prices));

    }
}
