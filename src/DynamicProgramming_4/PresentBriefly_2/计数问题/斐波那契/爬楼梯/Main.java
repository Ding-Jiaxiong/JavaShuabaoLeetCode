package DynamicProgramming_4.PresentBriefly_2.计数问题.斐波那契.爬楼梯;

public class Main {

    public static int climbStairs(int n) {

        if (n <= 2) return n;

        int[] dp = new int[n + 1];  // dp[i] 表示到达 i 阶需要的步数

        // 初始状态
        dp[1] = 1;
        dp[2] = 2;

        // 递推公式: dp[i] = dp[i - 1] + dp[i - 2]
        for (int i = 3; i <= n; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 2;

        System.out.println(climbStairs(n));
    }
}
