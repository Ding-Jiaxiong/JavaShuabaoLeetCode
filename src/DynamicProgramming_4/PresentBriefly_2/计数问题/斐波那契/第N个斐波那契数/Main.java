package DynamicProgramming_4.PresentBriefly_2.计数问题.斐波那契.第N个斐波那契数;

public class Main {

    public static int tribonacci(int n) {

        // 递推公式和上道题差不多
        if (n <= 1) return n;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {

            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 25;

        System.out.println(tribonacci(n));
    }
}
