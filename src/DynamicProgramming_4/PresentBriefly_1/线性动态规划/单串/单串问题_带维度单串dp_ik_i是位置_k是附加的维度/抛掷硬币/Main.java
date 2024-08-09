package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_带维度单串dp_ik_i是位置_k是附加的维度.抛掷硬币;

public class Main {

    public static double probabilityOfHeads(double[] prob, int target) {

        int n = prob.length;  // 硬币数量

        double[][] dp = new double[n + 1][target + 1];  // dp[i][j] 表示前 i 枚硬币中正面朝上的硬币数恰好是 j 的概率

        dp[0][0] = 1.0;  // 没有硬币时，正面朝上的硬币数为 0 的概率为 1

        for (int i = 1; i <= n; i++) {  // 遍历每一枚硬币

            double p = prob[i - 1];  // 获取第 i 枚硬币正面朝上的概率

            for (int j = 0; j <= target; j++) {

                dp[i][j] = dp[i - 1][j] * (1 - p); // 当前硬币背面朝上的概率

                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1] * p; // 当前硬币正面朝上的概率
                }

            }

        }


        return dp[n][target];  // 返回正面朝上的硬币数等于 target 的概率

    }

    public static void main(String[] args) {

        double[] prob = {0.5, 0.5, 0.5, 0.5, 0.5};

        int target = 0;

        System.out.println(probabilityOfHeads(prob, target));

    }
}
