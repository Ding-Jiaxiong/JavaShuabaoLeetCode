package DynamicProgramming_4.PresentBriefly_2.计数问题.斐波那契.斐波那契数;

public class Main {

    public static int fib(int n) {

        // 递推公式： dp[i] = dp[i - 1] + dp[i - 2]

        if (n <= 1) return n;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];
        }


        return dp[n];

    }

    public static void main(String[] args) {

        int n = 2;

        System.out.println(fib(n));

    }
}
