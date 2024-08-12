package DynamicProgramming_4.PresentBriefly_2.计数问题.斐波那契.使用最小花费爬楼梯;

public class Main {

    public static int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        // dp[i] 表示到达第 i 个台阶的最小花费
        int[] dp = new int[n + 1];

        // 初始化
        dp[0] = 0;
        dp[1] = 0;

        // 开始
        for (int i = 2; i <= n; i++) {

            // 递推公式：dp[i]=min(dp[i−1]+cost[i−1],dp[i−2]+cost[i−2])
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int[] cost = {10, 15, 20};

        System.out.println(minCostClimbingStairs(cost));

    }
}
