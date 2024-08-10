package DynamicProgramming_4.PresentBriefly_1.前缀和.运算推广.运算推广问题_前缀积.乘积最大子数组;

public class Main {

    public static int maxProduct(int[] nums) {

        int maxPro = nums[0]; // 最大积
        int minPro = nums[0];  // 最小积

        int result = nums[0];  // 结果

        for (int i = 1; i < nums.length; i++) {

            int current = nums[i];

            // 当前元素为负，交换
            if (current < 0) {
                int temp = maxPro;
                maxPro = minPro;
                minPro = temp;
            }

            maxPro = Math.max(current, maxPro * current);
            minPro = Math.min(current, minPro * current);

            // 更新全局最大积
            result = Math.max(result, maxPro);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, -2, 4};

        System.out.println(maxProduct(nums));
    }

}
