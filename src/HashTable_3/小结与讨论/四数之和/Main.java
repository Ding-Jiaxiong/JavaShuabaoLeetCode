package HashTable_3.小结与讨论.四数之和;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int res = 0;  // 次数结果

        Map<Integer, Integer> map = new HashMap<>();  // 键是和值，值是次数

        // 前两个数组
        for (int num1 : nums1) {
            for (int num2 : nums2) {

                int sum = num1 + num2;

                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // 后两个数组
        for (int num3 : nums3) {
            for (int num4 : nums4) {

                res += map.getOrDefault(0 - num3 - num4, 0);  // 直接看有没有和能为 0 的，拿出来加入结果
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};

        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));

    }
}
