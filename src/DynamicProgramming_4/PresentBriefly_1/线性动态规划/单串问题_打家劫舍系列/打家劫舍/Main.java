package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串问题_打家劫舍系列.打家劫舍;

public class Main {

    public static int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        // 简单dp【转移公式是偷或者不偷 第 i 个房子】
        int[] dp = new int[nums.length];  // dp[i] 表示前 i 号房屋所能偷窃到的最高金额

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {

            // dp[i - 1] 就是不偷i，dp[i - 2] + nums[i] 就是偷 i
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {

        int[] amounts = {1, 2, 3, 1};

        System.out.println(rob(amounts));

    }
}
