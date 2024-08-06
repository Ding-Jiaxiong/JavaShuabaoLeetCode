package ArrayAndString_2.双指针技巧.最大连续1的个数;

public class Main {

    public static int findMaxConsecutiveOnes(int[] nums) {

        int slow = 0;
        int fast = 0;

        int maxlen = 0;


        while (fast < nums.length) {

            // 让快指针走到非 1 的位置
            while (fast < nums.length && nums[fast] == 1) fast++;

            maxlen = Math.max(maxlen, fast - slow);

            // 让慢指针前进到下一个 1 开始的位置
            while (fast < nums.length && nums[fast] == 0) fast++;

            slow = fast;
        }


        return maxlen;

    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 1, 1, 1};

        System.out.println(findMaxConsecutiveOnes(nums));

    }
}
