package DynamicProgramming_4.PresentBriefly_2.背包动态规划.组合问题_求方案数.组合总和IV;

public class Main {

    public static int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];  // dp[i]表示当目标值为i时，有多少种组合方式可以得到这个值

        dp[0] = 1;  // 啥也不选

        for (int i = 1; i <= target; i++) {

            for (int num : nums) {

                // 如果当前目标值大于等于num
                if (i >= num) dp[i] += dp[i - num];  // 当前目标值的组合数加上去掉num之后的组合数
            }
        }


        return dp[target];

    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        int target = 4;

        System.out.println(combinationSum4(nums, target));

    }
}
