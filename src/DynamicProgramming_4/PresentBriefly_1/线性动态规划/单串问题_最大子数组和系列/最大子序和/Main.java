package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串问题_最大子数组和系列.最大子序和;

public class Main {

    public static int maxSubArray(int[] nums) {

        // 简单dp
        int[] dp = new int[nums.length];   // dp[i] 表示以 nums[i] 结尾的子数组的最大和

        int maxres = nums[0];  // 最大和值

        dp[0] = nums[0]; // 第一个数最大和就是自己

        for (int i = 1; i < nums.length; i++) {  // 遍历后序数

            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);  // 继续累加或者从当前元素重新开始

            maxres = Math.max(maxres, dp[i]); // 更新当前最大值
        }

        return maxres;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(nums));

    }
}
