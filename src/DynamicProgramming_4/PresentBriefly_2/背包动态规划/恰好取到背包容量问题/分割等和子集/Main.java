package DynamicProgramming_4.PresentBriefly_2.背包动态规划.恰好取到背包容量问题.分割等和子集;

public class Main {

    public static boolean canPartition(int[] nums) {

        // 数组总和
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        // 总和是奇数，没法分
        if (sum % 2 != 0) return false;

        // 目标是找到一个子集，使其和是总和的一半
        int target = sum / 2;

        // dp[i] 表示是否可以找到和为 i 的子集
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;  // 空集

        for (int num : nums) {

            for (int i = target; i >= num; i--) {

                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 11, 5};

        System.out.println(canPartition(nums));

    }
}
