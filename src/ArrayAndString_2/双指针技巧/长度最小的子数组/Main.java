package ArrayAndString_2.双指针技巧.长度最小的子数组;

public class Main {

    public static int minSubArrayLen(int target, int[] nums) {

        // 双指针【滑动窗口】
        int curSum = 0;  // 当前窗口中的数值和

        int left = 0;
        int right = 0;

        int subarrayLength = Integer.MAX_VALUE;

        while (right < nums.length) {

            curSum += nums[right];

            while (curSum >= target) {

                int curlen = right - left + 1;

                subarrayLength = Math.min(subarrayLength, curlen);

                curSum -= nums[left];
                left++;
            }


            right++;

        }

        return subarrayLength == Integer.MAX_VALUE ? 0 : subarrayLength;

    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};

        int target = 7;

        System.out.println(minSubArrayLen(target, nums));

    }
}
