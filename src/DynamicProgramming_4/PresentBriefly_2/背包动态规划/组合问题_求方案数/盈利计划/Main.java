package DynamicProgramming_4.PresentBriefly_2.背包动态规划.组合问题_求方案数.盈利计划;

public class Main {

    private static final int MOD = 1000000007;

    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

        int[][] dp = new int[n + 1][minProfit + 1];  // dp[i][j] 表示用 i 个员工并且至少获得 j 利润的计划数

        // 空计划，没有利润要求
        dp[0][0] = 1;

        // 每一种工作
        for (int k = 0; k < group.length; k++) {

            int members = group[k];  // 当前工作需要的成员数量
            int earn = profit[k];  // 当前工作产生的利润

            // 倒序遍历
            for (int i = n; i >= members; i--) {

                for (int j = minProfit; j >= 0; j--) {

                    // 选择当前工作后最少可以获得的利润
                    int newProfit = Math.max(0, j - earn);

                    // 更新
                    dp[i][j] = (dp[i][j] + dp[i - members][newProfit]) % MOD;
                }
            }
        }

        int result = 0;  // 总的方案数

        for (int i = 0; i <= n; i++) {

            result = (result + dp[i][minProfit]) % MOD;
        }


        return result;
    }

    public static void main(String[] args) {

        int n = 5;
        int minProfit = 3;

        int[] group = {2, 2};
        int[] profix = {2, 3};

        System.out.println(profitableSchemes(n, minProfit, group, profix));
    }
}
