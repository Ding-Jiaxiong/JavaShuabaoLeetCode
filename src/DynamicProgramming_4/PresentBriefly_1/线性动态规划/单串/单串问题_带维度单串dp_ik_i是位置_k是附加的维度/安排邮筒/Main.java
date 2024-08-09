package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_带维度单串dp_ik_i是位置_k是附加的维度.安排邮筒;

import java.util.Arrays;

public class Main {

    public static int minDistance(int[] houses, int k) {

        int n = houses.length;

        Arrays.sort(houses);  // 房子位置排序

        int[][] medsum = new int[n][n];  // dp[i][j] 表示从第 i 个房子到第 i 个房子设置邮局的代价

        for (int i = n - 2; i >= 0; i--) {  // 从倒数第二个房子开始

            for (int j = i + 1; j < n; j++) {  // 第 i 个房子的下一个房子开始看

                medsum[i][j] = medsum[i + 1][j - 1] + houses[j] - houses[i];
            }
        }

        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);  // 将每个位置初始化为一个大值，表示初始状态下的无穷大
        }

        for (int i = 0; i < n; i++) {
            dp[i][1] = medsum[0][i];  // 当只有一个邮局时，代价就是从第0个房子到第i个房子的代价

            for (int j = 2; j <= k && j <= i + 1; j++) {  // 遍历邮局数量

                for (int l = 0; l < i; l++) {

                    dp[i][j] = Math.min(dp[i][j], dp[l][j - 1] + medsum[l + 1][i]);
                }
            }
        }

        return dp[n - 1][k];  // 返回 n 个房子中设置 k 个邮局的最小代价

    }

    public static void main(String[] args) {

        int[] houses = {1, 4, 8, 10, 20};

        int k = 3;

        System.out.println(minDistance(houses, k));

    }
}
