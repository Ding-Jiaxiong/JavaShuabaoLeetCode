package DynamicProgramming_4.PresentBriefly_2.计数问题.隐晦的递推关系.学生出勤记录II;

public class Main {

    // 取模常数
    private static final int MOD = 1000000007;

    public static int checkRecord(int n) {

        // dp[i][j][k]表示前i天中有j次缺勤且最后连续迟到天数为k的合法出勤记录数量
        int[][][] dp = new int[n + 1][2][3];

        // 初始化
        dp[0][0][0] = 1;  // 前0天，0次缺勤，0次连续迟到，合法记录数为1

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < 2; j++) {  // 缺勤最多一次

                for (int k = 0; k < 3; k++) {  // 连续迟到最多 2 次

                    // 今天到场，连续迟到清零，缺勤次数不变
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;

                    // 今天缺勤，连续迟到清零，缺勤次数加1
                    if (j > 0) {
                        dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j - 1][k]) % MOD;
                    }

                    // 今天迟到，连续迟到次数加1，缺勤次数不变
                    if (k > 0){
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                    }
                }
            }
        }

        // 记录所有合法
        int res = 0;

        for (int j = 0; j < 2; j++) {  // 缺勤最多一次

            for (int k = 0; k < 3; k++) {  // 连续迟到最多 2 次

                res = (res + dp[n][j][k]) % MOD;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int n = 2;

        System.out.println(checkRecord(n));

    }
}
