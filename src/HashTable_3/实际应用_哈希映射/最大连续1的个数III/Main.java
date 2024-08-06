package HashTable_3.实际应用_哈希映射.最大连续1的个数III;

public class Main {

    public static int longestOnes(int[] nums, int k) {

        int len = nums.length;

        // 特判
        if (len == 1) return nums[0] == 1 || k > 0 ? 1 : 0;  // 如果本来就为 1 就直接返回，如果为 0 还有替换次数也返回 1

        int zeroCount = 0;  // 记录窗口中 0 的个数

        int res = 0;  // 返回结果

        // 滑动窗口的左右边界
        int left = 0;
        int right = 0;

        while (right < len) { // 右边界到底，循环结束

            // 右边界遇到 0 ，就增加 zeroCount
            if (nums[right] == 0) zeroCount++;

            // 如果窗口中 0 的数量超过 k 了，就要右移左边界了
            while (zeroCount > k) {
                if (nums[left] == 0) zeroCount--;

                left++;
            }

            res = Math.max(res, right - left + 1);

            right++; // 右边界一直走
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;

        System.out.println(longestOnes(nums, k));

    }
}
