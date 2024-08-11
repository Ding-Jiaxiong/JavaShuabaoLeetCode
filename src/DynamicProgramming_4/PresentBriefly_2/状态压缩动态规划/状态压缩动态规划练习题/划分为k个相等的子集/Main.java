package DynamicProgramming_4.PresentBriefly_2.状态压缩动态规划.状态压缩动态规划练习题.划分为k个相等的子集;

import java.util.Arrays;

public class Main {

    public static boolean canPartitionKSubsets(int[] nums, int k) {

        // 数组总和
        int sum = Arrays.stream(nums).sum();

        if (sum % k != 0) return false;  // 总和不能被 k 整除，返回 false

        // 每个子集的目标和
        int target = sum / k;

        // 排序
        Arrays.sort(nums);

        // 如果数组中最大的数大于目标和，无法分割，返回 false
        if (nums[nums.length - 1] > target) return false;

        // 用一个数组记录 k 个子集的当前和
        int[] buckets = new int[k];

        // 又来回溯
        return backtrack(nums, nums.length - 1, buckets, target);
    }

    private static boolean backtrack(int[] nums, int index, int[] buckets, int target) {

        if (index < 0) return true;  // 所有数分配完毕

        // 遍历每个子集
        for (int i = 0; i < buckets.length; i++) {

            // 如果当前子集加上当前数后的和小于或等于目标和
            if (buckets[i] + nums[index] <= target) {

                // 将当前数放入子集中
                buckets[i] += nums[index];

                // 递归处理下一个数
                if (backtrack(nums, index - 1, buckets, target)) {
                    return true;
                }

                // 回溯，将当前数移出子集
                buckets[i] -= nums[index];
            }

            // 如果当前子集的和为 0，说明这个子集还未被使用
            // 如果一个空子集放不下当前数，那么其他空子集也放不下，直接跳过
            if (buckets[i] == 0) break;

        }

        // 如果所有子集都无法容纳当前数，返回 false
        return false;
    }


    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;

        System.out.println(canPartitionKSubsets(nums, k));

    }
}
