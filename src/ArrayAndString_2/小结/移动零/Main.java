package ArrayAndString_2.小结.移动零;

public class Main {

    public static void swap(int[] nums, int i, int j) {

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void moveZeroes(int[] nums) {

        // 双指针
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {

            if (nums[fast] != 0) {

                swap(nums, slow, fast);

                slow++;
            }

            fast++;
        }

    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        for (int num : nums) {
            System.out.print(num + " ");
        }

        moveZeroes(nums);
        System.out.println();

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
