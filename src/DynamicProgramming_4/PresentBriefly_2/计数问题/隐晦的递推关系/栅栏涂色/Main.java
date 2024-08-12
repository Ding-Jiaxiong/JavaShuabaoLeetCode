package DynamicProgramming_4.PresentBriefly_2.计数问题.隐晦的递推关系.栅栏涂色;

public class Main {

    public static int numWays(int n, int k) {


        // 递推公式：dp[i] = (k-1) * (dp[i-1] + dp[i-2])

        if (n == 0) return 0; // 没有柱子，没有方案
        if (n == 1) return k; // 一个柱子，k 种方案

        int[] dp = new int[n + 1];

        dp[1] = k;
        dp[2] = k * k;  // 两个柱子

        // 递推
        for (int i = 3; i <= n; i++) {

            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 3;
        int k = 2;

        System.out.println(numWays(n, k));
    }
}
