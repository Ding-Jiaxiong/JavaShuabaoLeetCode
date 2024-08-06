package Array_1.双索引技巧_滑动窗口;

public class Main {

    public static int minSubArrayLen(int target, int[] nums) {

        // 连续子数组
        int left = 0;
        int right = 0;

        int cursum = 0;   // 当前窗口中的和

        int res = Integer.MAX_VALUE;  // 子数组的长度 【要找最小的所以设置成最大】

        while (right < nums.length) { // 还没有滑到末尾

            cursum += nums[right];

            while (cursum >= target) {

                // 当前窗口长度
                int curlen = right - left + 1;

                if (curlen < res) res = curlen;

                cursum -= nums[left];
                left++;

            }

            right++;

        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;

        System.out.println(minSubArrayLen(target, nums));

    }

}
