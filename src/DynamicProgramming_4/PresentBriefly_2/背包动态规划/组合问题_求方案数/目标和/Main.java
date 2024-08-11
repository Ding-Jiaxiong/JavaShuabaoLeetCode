package DynamicProgramming_4.PresentBriefly_2.背包动态规划.组合问题_求方案数.目标和;

public class Main {

    public static int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        // 计算总和
        for (int num : nums) {
            sum += num;
        }

        // 特判
        if (sum + target < 0 || (sum + target) % 2 != 0 || target > sum) {
            return 0;
        }

        int newTarget = (sum + target) / 2;

        return subsetSum(nums, newTarget);

    }

    private static int subsetSum(int[] nums, int target) {

        // dp[i] 表示和为 i 的子集的个数
        int[] dp = new int[target + 1];

        dp[0] = 1;  // 空集

        for (int num : nums) {

            for (int j = target; j >= num; j--) {

                // dp[j] 当前为止能凑成的个数 + 减去当前数 num 后能凑成的个数
                dp[j] += dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 1, 1};

        int target = 3;

        System.out.println(findTargetSumWays(nums, target));

    }
}
