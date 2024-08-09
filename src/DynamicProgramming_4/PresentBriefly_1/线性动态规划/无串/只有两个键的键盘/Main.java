package DynamicProgramming_4.PresentBriefly_1.线性动态规划.无串.只有两个键的键盘;

public class Main {

    public static int minSteps(int n) {

        if (n == 1) return 0; // 无需进行操作

        int[] dp = new int[n + 1];  // dp[i] 表示打印出 i 个 'A' 所需的最少操作次数

        for (int i = 2; i <= n; i++) {

            // 最坏情况下, 只能通过一次次粘贴得到 i 个 'A'
            dp[i] = i;

            // 尝试所有可能的 j 作为因子
            for (int j = 2; j <= Math.sqrt(i); j++) {

                if (i % j == 0) {  //  i 可以被 j 整除，则可以通过 dp[j] 和 dp[i/j] 来得到 dp[i]
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }

        // 打印出 n 个 'A' 的最少操作次数
        return dp[n];

    }

    public static void main(String[] args) {

        int n = 3;

        System.out.println(minSteps(n));

    }
}
