package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_股票系列_dp_i_k_state_i是时间_k是次数_state是状态.买卖股票的最佳时机II;

public class Main {

    public static int maxProfit(int[] prices) {

        // 贪心【上涨都买卖，下降都不买卖】
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {

            int tmp = prices[i] - prices[i - 1];

            if (tmp > 0) { // 上涨

                profit += tmp;
            }
        }

        return profit;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));

    }
}
