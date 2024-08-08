package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串问题_其他单串dp_i问题.使序列递增的最小交换次数;

public class Main {

    public static int minSwap(int[] nums1, int[] nums2) {

        // 困难题
        int n = nums1.length;

        int[] keep = new int[n]; // 在位置 i 处不交换，使得两个数组严格递增的最小交换次数
        int[] swap = new int[n]; // 在位置 i 处，交换nums1[i] 和 nums2[i]，使得两个数组严格递增的最小交换次数

        keep[0] = 0; // 起始位置没有交换
        swap[0] = 1; // 起始位置交换一次

        for (int i = 1; i < n; i++) {

            keep[i] = Integer.MAX_VALUE;
            swap[i] = Integer.MAX_VALUE;

            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                // 不用管，还是升序的
                keep[i] = keep[i - 1]; // 不变
                swap[i] = swap[i - 1] + 1;  // 发生一次交换， +1
            }

            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {  // 可以在 i 处进行交换
                keep[i] = Math.min(keep[i], swap[i - 1]);
                swap[i] = Math.min(swap[i], keep[i - 1] + 1);
            }
        }

        return Math.min(keep[n - 1], swap[n - 1]);
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 3, 5, 4};
        int[] nums2 = {1, 2, 3, 7};

        System.out.println(minSwap(nums1, nums2));

    }
}
