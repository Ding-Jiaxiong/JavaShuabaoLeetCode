package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_带维度单串dp_ik_i是位置_k是附加的维度.鸡蛋掉落;

public class Main {

    public static int superEggDrop(int k, int n) {

        int[][] dp = new int[k + 1][n + 1]; // dp[i][j] 表示用 i 个蛋，最多 j 次操作就可以确定的楼层数

        int m = 0;

        // 不断增加操作次数 m，直到 dp[k][m] >= n
        while (dp[k][m] < n) {
            m++;

            for (int i = 1; i <= k; i++) {

                dp[i][m] = dp[i - 1][m - 1] + dp[i][m - 1] + 1;
            }
        }

        // m 最后就是确定 楼层 n 所需要的最小操作次数
        return m;
    }

    public static void main(String[] args) {

        int k = 2;
        int n = 6;

        System.out.println(superEggDrop(k, n));
    }
}
