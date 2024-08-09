package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_股票系列_dp_i_k_state_i是时间_k是次数_state是状态.买卖股票的最佳时机;

public class Main {

    public static int maxProfit(int[] prices) {

        int maxPro = 0; // 最大利润
        int minPrice = prices[0];  // 最小价格

        for (int i = 1; i < prices.length; i++) {

            minPrice = Math.min(prices[i], minPrice);

            // 当前利润
            int currentPro = prices[i] - minPrice;

            maxPro = Math.max(currentPro, maxPro);

        }

        return maxPro;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));

    }
}
