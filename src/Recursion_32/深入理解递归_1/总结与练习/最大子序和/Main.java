package Recursion_32.深入理解递归_1.总结与练习.最大子序和;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 15:28
 * */

public class Main {

    public static int maxSubArray(int[] nums) {

        int maxSum = nums[0];  // 最大

        int currentSum = nums[0];  // 当前

        // 直接遍历数组
        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // 更新
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(nums));

    }
}
