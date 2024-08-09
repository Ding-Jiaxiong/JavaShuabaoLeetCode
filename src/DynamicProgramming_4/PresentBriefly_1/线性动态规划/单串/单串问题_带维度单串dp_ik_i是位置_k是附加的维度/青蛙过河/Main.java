package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_带维度单串dp_ik_i是位置_k是附加的维度.青蛙过河;

public class Main {

    public static boolean canCross(int[] stones) {

        int n = stones.length;

        boolean[][] dp = new boolean[n][n]; // dp[i][k] 表示青蛙能够跳跃距离 k 到达第 i 块石头

        dp[0][0] = true;  // 初始状态，没有跳，第 0 块石头

        for (int i = 1; i < n; i++) {
            if (stones[i] - stones[i - 1] > i) {  // 如果两块相邻石头之间的距离大于青蛙从前一个石头跳到当前石头所允许的最大距离（即 i），无法跨越，直接结束
                return false;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {

                int k = stones[i] - stones[j];  // 从石头 j 跳到石头 i 所需的距离

                if (k > j + 1) { // 所需的距离大于青蛙从第 j 个石头跳出的最大可能距离（即 j + 1）
                    break;  // 跳不了
                }

                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1]; // 青蛙是否可以从石头 j 通过距离 k-1、k 或 k+1 跳跃到石头 i

                if (i == n - 1 && dp[i][k]) {  // 如果青蛙可以跳到最后一个石头，并且当前跳跃是可能的，返回 true
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};

        System.out.println(canCross(stones));

    }
}
