package DynamicProgramming_4.PresentBriefly_2.计数问题.隐晦的递推关系.骑士拨号器;

import java.util.Arrays;

public class Main {

    public static int knightDialer(int n) {

        int MOD = 1_000_000_007; // 模数

        // 骑士可以从每个数字跳转到的其他数字
        int[][] moves = new int[][]{
                {4, 6},   // 从数字0可以跳到4和6
                {6, 8},   // 从数字1可以跳到6和8
                {7, 9},   // 从数字2可以跳到7和9
                {4, 8},   // 从数字3可以跳到4和8
                {3, 9, 0}, // 从数字4可以跳到3、9和0
                {},      // 从数字5没有跳转的选项
                {1, 7, 0}, // 从数字6可以跳到1、7和0
                {2, 6},   // 从数字7可以跳到2和6
                {1, 3},   // 从数字8可以跳到1和3
                {2, 4}    // 从数字9可以跳到2和4
        };

        int[][] dp = new int[2][10]; // dp[0]和dp[1]分别用于保存当前和前一轮的结果

        Arrays.fill(dp[0], 1);  // 初始状态下，每个数字可以构成1种有效的路径（长度为1）

        // 每一跳
        for (int hops = 0; hops < n - 1; hops++) {

            Arrays.fill(dp[~hops & 1], 0);  // 清空当前状态

            for (int node = 0; node < 10; node++) {  // 遍历每个数字

                for (int nei : moves[node]) {  // 遍历所有跳转选项

                    dp[~hops & 1][nei] += dp[hops & 1][node]; // 更新跳转后的数字的路径计数
                    dp[~hops & 1][nei] %= MOD; // 对结果取模，避免溢出
                }
            }
        }

        long ans = 0;  // 结果

        for (int x : dp[~n & 1]) // 累加所有数字的路径计数
            ans += x;

        return (int) (ans % MOD);

    }

    public static void main(String[] args) {

        int n = 2;

        System.out.println(knightDialer(n));

    }
}
