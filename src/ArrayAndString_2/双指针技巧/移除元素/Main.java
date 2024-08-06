package ArrayAndString_2.双指针技巧.移除元素;

public class Main {

    public static void swap(int[] nums, int i, int j) {

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static int removeElement(int[] nums, int val) {

        // 做过移动零吗
        if (nums.length == 0) return 0;

        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {

            if (nums[fast] != val) {

                swap(nums, slow, fast);

                slow++;
            }

            fast++;
        }


        return slow ;

    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 2, 3};

        int val = 3;

        System.out.println(removeElement(nums, val));

    }
}
