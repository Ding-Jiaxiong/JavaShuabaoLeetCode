package DynamicProgramming_4.PresentBriefly_2.计数问题.卡特兰数.不相交的握手;

import java.math.BigInteger;

public class Main {


    public static int numberOfWays(int numPeople) {

        // 取模常数
        int mod = 1000000007;

        int n = numPeople;  // 人数

        long[] dp = new long[n + 1];  // dp[i] 表示将 i 个人分组并以不交叉的方式握手的方案总数

        dp[0] = 1;  // 0个人时的方式数为1
        dp[1] = 1; // 用不到

        // 从 2 开始
        for (int i = 2; i <= n; i += 2) {

            dp[i] = 0; // 初始化

            // 不同子问题的结果相乘累加
            for (int j = 1; j < i; j += 2) {

                dp[i] = (dp[i] + (dp[j - 1] * dp[i - j - 1]) % mod) % mod;
            }
        }

        return (int) dp[n];

    }

    public static void main(String[] args) {

        int num_people = 2;

        System.out.println(numberOfWays(num_people));

    }
}
