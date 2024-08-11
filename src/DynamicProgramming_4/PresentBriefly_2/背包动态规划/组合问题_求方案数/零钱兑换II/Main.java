package DynamicProgramming_4.PresentBriefly_2.背包动态规划.组合问题_求方案数.零钱兑换II;

public class Main {

    public static int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];  // dp[i] 表示凑成金额 i 的组合数

        dp[0] = 1;  // 啥也不选

        for (int coin : coins) {

            for (int i = coin; i <= amount; i++) {

                // dp[i] 表示不使用当前硬币时凑成金额 i 的组合数，加上使用当前硬币时的组合数
                dp[i] += dp[i - coin];
            }
        }

        // 凑成总金额 amount 的组合数
        return dp[amount];
    }

    public static void main(String[] args) {

        int amount = 5;

        int[] coins = {1, 2, 5};

        System.out.println(change(amount, coins));

    }
}
