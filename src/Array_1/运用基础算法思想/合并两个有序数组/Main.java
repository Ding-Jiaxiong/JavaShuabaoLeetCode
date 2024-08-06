package Array_1.运用基础算法思想.合并两个有序数组;

public class Main {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // 尾插法，nums1 后面就是专门用来搞 的

        int i = m - 1;
        int j = n - 1;

        int cur = m + n - 1;

        while (j >= 0) {  // 只要 nums2 中的数还没遍历完就继续

            if (i >= 0 && nums1[i] > nums2[j]) {  // 在这里判断 nums1 中的数是否遍历完, 确保 i 不会变成负数
                nums1[cur--] = nums1[i--];
            } else {
                nums1[cur--] = nums2[j--];
            }

        }

    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        for (int i : nums1) {
            System.out.print(i + " ");
        }

    }

}
