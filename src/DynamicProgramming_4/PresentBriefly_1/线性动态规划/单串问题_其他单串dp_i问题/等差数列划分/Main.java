package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串问题_其他单串dp_i问题.等差数列划分;

import sun.plugin2.gluegen.runtime.CPU;

public class Main {

    public static int numberOfArithmeticSlices(int[] nums) {

        if (nums.length < 3) return 0;

        int count = 0;  // 结果个数

        int[] dp = new int[nums.length];  // 以 nums[i] 数结尾的子数组是等差数列的个数

        dp[0] = 0;
        dp[1] = 0;  // 因为至少要 3 个数，所以初始前两个值都为 0

        for (int i = 2; i < nums.length; i++) {

            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {

                // 等差
                dp[i] = dp[i - 1] + 1;  // 就等于前一个的加上当前这种情况
            }

            count += dp[i];  // 最后个数也加上
        }


        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        System.out.println(numberOfArithmeticSlices(nums));
    }
}
