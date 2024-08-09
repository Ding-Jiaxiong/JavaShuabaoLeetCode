package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_带维度单串dp_ik_i是位置_k是附加的维度.分割数组的最大值;

import java.util.Arrays;

public class Main {

    public static int splitArray(int[] nums, int k) {

        int len = nums.length;  // 数组长度

        int[] preSum = new int[len + 1];  // 前缀和数组

        preSum[0] = 0;  // 第一个元素，没有元素，和为 0

        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];  // 计算前缀和数组
        }

        int[][] dp = new int[len][k + 1]; // dp[i][j] 表示将前 i 个元素分成 j 组时的最小化最大子数组和

        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);   // 初始化为一个很大的值
        }

        // 分割数为 1，即不分割的情况
        for (int i = 0; i < len; i++) {
            dp[i][1] = preSum[i + 1];  // 不分割的情况下，dp[i][1] 就是对应的前缀和
        }

        // 分割次数为 2 开始
        for (int count = 2; count <= k; count++) {

            for (int i = count - 1; i < len; i++) {  // 当前子数组的结束位置

                for (int j = count - 2; j < i; j++) { // 子数组的起始位置

                    // 在前 j 个元素已经分成 count - 1 组的情况下，当前分组所能取得的最大子数组和的最小化
                    dp[i][count] = Math.min(dp[i][count], Math.max(dp[j][count - 1], preSum[i + 1] - preSum[j + 1]));
                }
            }
        }

        return dp[len - 1][k];  // 整个数组分成 k 组时的最小化最大子数组和

    }

    public static void main(String[] args) {

        int[] nums = {7, 2, 5, 10, 8};

        int k = 2;

        System.out.println(splitArray(nums, k));

    }
}
