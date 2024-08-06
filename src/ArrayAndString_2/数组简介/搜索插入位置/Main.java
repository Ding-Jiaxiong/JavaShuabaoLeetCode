package ArrayAndString_2.数组简介.搜索插入位置;

public class Main {

    public static int searchInsert(int[] nums, int target) {

        // 二分
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {  //

            int mid = left + (right - left) / 2;

            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else return mid;
        }

        return left;

    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6};

        int target = 5;

        System.out.println(searchInsert(nums, target));

    }
}
