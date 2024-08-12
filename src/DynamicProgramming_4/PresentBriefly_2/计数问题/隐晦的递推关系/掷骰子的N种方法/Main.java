package DynamicProgramming_4.PresentBriefly_2.计数问题.隐晦的递推关系.掷骰子的N种方法;

public class Main {

    // 取模常数
    private static final int MOD = 1000000007;

    public static int numRollsToTarget(int n, int k, int target) {

        int[][] dp = new int[n + 1][target + 1]; // dp[i][j] 表示用 i 个骰子得到总和为 j 的方法数

        // 不掷骰子时总和为 0 的方法只有一种，就是不做任何操作
        dp[0][0] = 1;

        // 遍历所有骰子数
        for (int i = 1; i <= n; i++) {

            // 遍历可能的总和值
            for (int j = 1; j <= target; j++) {

                // 初始化
                dp[i][j] = 0;

                // 遍历每个骰子可能的面值
                for (int face = 1; face <= k; face++) {

                    // 当前面值 face 小于等于当前总和 j
                    if (j >= face) {
                        // 累加
                        // 递推公式：dp[i][j] = (dp[i][j] + dp[i - 1][j - face])
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - face]) % MOD;
                    }
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {

        int n = 2, k = 6, target = 7;

        System.out.println(numRollsToTarget(n, k, target));
    }
}
