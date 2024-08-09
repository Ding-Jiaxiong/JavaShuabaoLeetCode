package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_其他单串dp_i问题.比特位计数;

public class Main {

    public static int[] countBits(int n) {

        // 特判
        if (n == 0) return new int[]{0};  // 没有

        int[] dp = new int[n + 1];  // dp[i] 表示数字 i 二进制中 1 的个数

        for (int i = 0; i <= n; i++) {

            // 对于每个数字i，其二进制中1的个数等于dp[i/2]（相当于i右移一位的结果）
            // 加上i的最低位是否为1的判断（i % 2），即加上i对2取余的结果
            dp[i] = dp[i / 2] + i % 2;
        }

        return dp;
    }

    public static void main(String[] args) {

        int n = 2;

        for (int bit : countBits(n)) {
            System.out.print(bit + " ");
        }
    }
}
