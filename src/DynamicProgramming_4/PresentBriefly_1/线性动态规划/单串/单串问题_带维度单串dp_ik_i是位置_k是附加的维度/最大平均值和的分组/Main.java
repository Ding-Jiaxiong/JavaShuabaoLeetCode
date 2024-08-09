package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_带维度单串dp_ik_i是位置_k是附加的维度.最大平均值和的分组;

public class Main {

    public static double largestSumOfAverages(int[] nums, int k) {

        int n = nums.length; // 数组长度

        double[] preSum = new double[n + 1];  // 数组的前缀和数组

        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        double[] dp = new double[n];  // dp[i] 表示将数组从第 i 个元素分割到最后的最大平均值和

        for (int i = 0; i < n; i++) {
            dp[i] = (preSum[n] - preSum[i]) / (n - i);  // 初始情况，dp[i] 就是第 i 个元素到最后一个元素的平均值
        }

        for (int i = 0; i < k - 1; i++) {  // 分割 k - 1次

            for (int j = 0; j < n; j++) {  // 遍历数组每个元素作为分割起点

                for (int l = j + 1; l < n; l++) {  // 尝试从 l 到 j 进行一次分割

                    dp[j] = Math.max(dp[j], (preSum[l] - preSum[j]) / (l - j) + dp[l]);  // 状态转移更新
                }

            }
        }

        return dp[0];

    }

    public static void main(String[] args) {

        int[] nums = {9, 1, 2, 3, 9};

        int k = 3;

        System.out.println(largestSumOfAverages(nums, k));

    }
}
