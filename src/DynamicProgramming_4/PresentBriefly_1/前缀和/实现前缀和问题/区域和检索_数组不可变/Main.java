package DynamicProgramming_4.PresentBriefly_1.前缀和.实现前缀和问题.区域和检索_数组不可变;

public class Main {

    // 前缀和

    static class NumArray {

        int[] sums;

        public NumArray(int[] nums) {

            int n = nums.length;

            sums = new int[n + 1];

            for (int i = 0; i < n; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {

            return sums[right + 1] - sums[left];
        }
    }

    public static void main(String[] args) {

        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});

        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));

    }
}
