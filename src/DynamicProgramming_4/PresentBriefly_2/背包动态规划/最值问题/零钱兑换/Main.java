package DynamicProgramming_4.PresentBriefly_2.背包动态规划.最值问题.零钱兑换;

public class Main {

    // 完全背包问题
    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];  // dp[i] 表示凑出金额 i 所需的最少硬币数

        for (int i = 1; i <= amount; i++) {

            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;  // 凑出金额 0 不需要硬币

        // 遍历每一种硬币面额
        for (int coin : coins) {

            // 对于当前硬币，更新所有大于等于该硬币面额的金额的 dp 值
            for (int i = coin; i <= amount; i++) {

                // dp[i - coin] 不是初始值，表示当前金额可以通过之前的金额加上一个当前硬币凑成
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }

        }

        // 初始值说明凑不出来
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};

        int amount = 11;

        System.out.println(coinChange(coins, amount));

    }
}
