package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_股票系列_dp_i_k_state_i是时间_k是次数_state是状态.买卖股票的最佳时机III;

public class Main {

//    public static int maxProfit(int[] prices) {
//
//        int n = prices.length;
//
//        /*
//           dp[i][0] 表示第 i 天结束，0 次交易的最大利润
//           dp[i][1] 表示第 i 天结束，1 次交易的最大利润
//           dp[i][2] 表示第 i 天结束，2 次交易的最大利润
//         */
//        int[][] dp = new int[n][3];
//
//        // 初始化
//        dp[0][0] = 0;  // 第一天不交易，利润为 0
//        dp[0][1] = -prices[0];  // 第一天买入一次，利润为负
//        dp[0][2] = 0;  // 第一天没法儿完成第二次，利润为 0
//
//        // 遍历每一天
//        for (int i = 1; i < n; i++) {
//
//            dp[i][0] = dp[i - 1][0];  // 不交易，利润不变
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);  // 进行一次交易的最大利润
//            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);  // 进行 2 次交易的最大利润
//        }
//
//        return dp[n - 1][2];  // 进行两次交易的最大利润直接返回
//    }

    public static int maxProfit(int[] prices) {

        int firstBuy = Integer.MIN_VALUE; // 第一次买入后的最大利润
        int firstSell = 0;  // 第一次卖出后的最大利润
        int secondBuy = Integer.MIN_VALUE;  // 第二次买入后的最大利润
        int secondSell = 0;  // 第二次卖出后的最大利润

        for (int price : prices) {

            firstBuy = Math.max(firstBuy, -price);  // 不买或者在今天买入

            firstSell = Math.max(firstSell, firstBuy + price);  // 不卖或者在今天卖出

            secondBuy = Math.max(secondBuy, firstSell - price);  // 不买或者在今天买入

            secondSell = Math.max(secondSell, secondBuy + price); // 不卖或者在今天卖出

        }


        return secondSell;
    }

    public static void main(String[] args) {

        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};

        System.out.println(maxProfit(prices));

    }
}
