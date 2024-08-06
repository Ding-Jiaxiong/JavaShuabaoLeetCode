package ArrayAndString_2.小结.删除排序数组中的重复项;

public class Main {

    public static int removeDuplicates(int[] nums) {

        // 双指针
        int slow = 0;
        int fast = 1;

        while (fast < nums.length) {

            if (nums[fast] > nums[slow]) {

                slow++;  // 这里要先修改我们要保留一个
                nums[slow] = nums[fast];
            }

            fast++;

        }

        return slow + 1;

    }

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println(removeDuplicates(nums));

    }
}
