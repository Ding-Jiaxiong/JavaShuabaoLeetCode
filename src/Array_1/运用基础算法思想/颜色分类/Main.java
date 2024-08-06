package Array_1.运用基础算法思想.颜色分类;

public class Main {

    public static void swap(int[] nums, int i, int j) {

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 荷兰国旗问题
    public static void sortColors(int[] nums) {

        /**
         * 0 红色
         * 1 白色
         * 2 蓝色
         */

        // 0 和 2 放两边，中间剩下的自然就是 1

        int red0 = 0;
        int blue2 = nums.length - 1;

        for (int i = 0; i <= blue2; i++) {  // 以蓝色的最前一个位置结束

            // 直接遍历整个数组
            if (nums[i] == 0) { // 红色
                swap(nums, red0, i);
                red0++;
            } else if (nums[i] == 2) { // 蓝色
                swap(nums, i, blue2);
                blue2--;  // 更新蓝色位置

                i--;  // 重新检查当前 i 位置的元素 【红色不用重新检查，放下就肯定是对的，而蓝色交换后，可能从后面拿了一个非 0 的数往前走】

            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}
