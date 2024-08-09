package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_最大子数组和系列.乘积最大子组数;

public class Main {

    public static int maxProduct(int[] nums) {

        // 当数组中有负数时，最大的乘积可能会出现在乘以一个负数之后再乘以另一个负数的情况。因此，需要同时跟踪最大和最小乘积。
        int[] maxdp = new int[nums.length];  // maxdp[i] 表示以 nums[i] 结尾的子数组的最大乘积
        int[] mindp = new int[nums.length];  // mindp[i] 表示以 nums[i] 结尾的子数组的最小乘积

        int res = nums[0];

        maxdp[0] = nums[0];
        mindp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {  // 遍历后序数

            if (nums[i] > 0) {

                maxdp[i] = Math.max(nums[i], maxdp[i - 1] * nums[i]);
                mindp[i] = Math.min(nums[i], mindp[i - 1] * nums[i]);
            } else {

                // 当前数是个负的
                maxdp[i] = Math.max(nums[i], mindp[i - 1] * nums[i]);
                mindp[i] = Math.min(nums[i], maxdp[i - 1] * nums[i]);
            }

            res = Math.max(res, maxdp[i]); // 更新当前最大值
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, -2, 4};

        System.out.println(maxProduct(nums));

    }
}
