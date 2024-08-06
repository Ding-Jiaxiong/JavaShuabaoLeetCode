package Array_1.做好初始定义.移动零;

public class Main {

    public static void swap(int[] nums, int i, int j) {

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }

    public static void moveZeroes(int[] nums) {

        // 特判
        if (nums.length == 0) return;

        // 双指针
        int zero = 0;  // 一直指向前面第一个 0 的位置

        for (int notzero = 0; notzero < nums.length; notzero++) {

            // 不为0 就往前挪
            if (nums[notzero] != 0) {

                swap(nums, notzero, zero);

                zero++;  // 第一个 0 的位置向前走
            }

        }

    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }

    }


}
