package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_打家劫舍系列.打家劫舍II;

public class Main {

    public static int rob(int[] nums) {

        // 两次 dp, 取最大值

        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        // 不偷第一个房子
        int max1 = robRange(nums, 1, nums.length - 1);

        // 偷第一个房子【就不能偷最后一个房子了】
        int max2 = robRange(nums, 0, nums.length - 2);

        return Math.max(max1, max2);
    }

    public static int robRange(int[] nums, int start, int end) {

        if (start == end) return nums[start];

        int[] dp = new int[end - start + 1];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        // 从第三个房子开始
        for (int i = 2; i <= end - start; i++) {

            // 偷或者不偷
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }

        return dp[end - start];

    }

    public static void main(String[] args) {

        int[] amounts = {2, 3, 2};

        System.out.println(rob(amounts));

    }
}
