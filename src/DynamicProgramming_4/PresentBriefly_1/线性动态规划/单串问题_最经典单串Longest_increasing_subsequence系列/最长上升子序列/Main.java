package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串问题_最经典单串Longest_increasing_subsequence系列.最长上升子序列;

import java.util.Arrays;

public class Main {

    public static int lengthOfLIS(int[] nums) {

        // 这个没有要求是连续子序列
        int[] dp = new int[nums.length];  // dp[i] 表示前 i 个数所能找出的最长上升子序列的长度

        Arrays.fill(dp, 1);  // 默认都为 1

        int maxlength = 1; // 默认最大长度也是1

        for (int i = 1; i < nums.length; i++) { // 从 第二个数 开始看

            for (int j = 0; j < i; j++) { // 比较前 i 个数

                if (nums[i] > nums[j]) {  // 找到上升情况
                    dp[i] = Math.max(dp[i], dp[j] + 1);  // 状态转移方程
                }
            }

            maxlength = Math.max(maxlength, dp[i]);  // 更新最大结果
        }

        return maxlength;
    }

    public static void main(String[] args) {

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lengthOfLIS(nums));

    }
}
