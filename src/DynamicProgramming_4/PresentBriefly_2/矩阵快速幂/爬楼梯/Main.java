package DynamicProgramming_4.PresentBriefly_2.矩阵快速幂.爬楼梯;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/22 16:34
 * */

public class Main {

    public static int climbStairs(int n) {

        int[] dp = new int[n + 1];

        // 初始化
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }

    public static void main(String[] args) {

        int n = 2;

        System.out.println(climbStairs(n));

    }
}
