package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_股票系列_dp_i_k_state_i是时间_k是次数_state是状态.买卖股票的最佳时机含手续费;

public class Main {

    public static int maxProfit(int[] prices, int fee) {

        int cash = 0;  // 手头上的钱
        int hold = -prices[0];  // 持有第一天的股票，现金变为 -prices[0]

        for (int i = 1; i < prices.length; i++) {

            cash = Math.max(cash, hold + prices[i] - fee);  // 卖掉今天的股票，并支付手续费，或保持之前的状态

            hold = Math.max(hold, cash - prices[i]);  // 今天买入股票，或保持之前的持有状态
        }


        return cash;

    }

    public static void main(String[] args) {

        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;

        System.out.println(maxProfit(prices, fee));

    }
}
