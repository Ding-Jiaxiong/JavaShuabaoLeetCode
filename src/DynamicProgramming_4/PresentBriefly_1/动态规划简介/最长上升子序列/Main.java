package DynamicProgramming_4.PresentBriefly_1.动态规划简介.最长上升子序列;

import java.util.Arrays;

public class Main {

    public static int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length]; // dp[i] 表示前 i 个数所能找出的最长上升子序列的长度

        int res = 0;

        Arrays.fill(dp, 1);  // 默认都是 1 【就他本身】

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {  // 后一个数比前一个数小

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            res = Math.max(res, dp[i]);  // res 就是 dp中的最大值
        }


        return res;

    }

    public static void main(String[] args) {

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lengthOfLIS(nums));

    }
}
