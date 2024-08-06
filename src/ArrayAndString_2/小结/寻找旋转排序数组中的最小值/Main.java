package ArrayAndString_2.小结.寻找旋转排序数组中的最小值;

public class Main {

    public static int findMin(int[] nums) {

        // 双指针
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            if (nums[left] < nums[right]) break;  // 如果左指针已经比右指针小了，说明左指针一定是最小值

            left++;
        }

        return nums[left];
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 1, 2};

        System.out.println(findMin(nums));

    }
}
