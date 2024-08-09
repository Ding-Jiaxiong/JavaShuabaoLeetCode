package DynamicProgramming_4.PresentBriefly_1.线性动态规划.无串.丑数II;

public class Main {

    public static int nthUglyNumber(int n) {

        int[] dp = new int[n];  // dp[i] 表示第 n - 1 个丑数

        dp[0] = 1; // 第一个丑数是 1

        int p2 = 0;
        int p3 = 0;
        int p5 = 0; // 分别对应丑数乘以 2、3 和 5 的位置

        for (int i = 1; i < n; i++) {

            int nextUgly = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));

            dp[i] = nextUgly;

            // 更新
            if (nextUgly == dp[p2] * 2) p2++;
            if (nextUgly == dp[p3] * 3) p3++;
            if (nextUgly == dp[p5] * 5) p5++;
        }


        return dp[n - 1];

    }

    public static void main(String[] args) {

        int n = 10;

        System.out.println(nthUglyNumber(n));
    }
}
