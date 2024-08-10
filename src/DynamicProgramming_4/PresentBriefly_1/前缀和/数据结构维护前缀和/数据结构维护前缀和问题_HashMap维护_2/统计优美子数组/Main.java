package DynamicProgramming_4.PresentBriefly_1.前缀和.数据结构维护前缀和.数据结构维护前缀和问题_HashMap维护_2.统计优美子数组;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int numberOfSubarrays(int[] nums, int k) {

        Map<Integer, Integer> prefixCount = new HashMap<>();  // 键是前缀和，值是出现次数

        prefixCount.put(0, 1);  // 前缀和为 0 的出现次数为 1

        int prefixSum = 0;  // 前缀和
        int niceSubarrayCount = 0;  // 优美子数组数量

        for (int num : nums) {

            // 当前数字是奇数，前缀和 +1
            if (num % 2 != 0) {
                prefixSum++;
            }

            // 检查是否存在一个前缀和，使得当前前缀和减去该前缀和等于k
            if (prefixCount.containsKey(prefixSum - k)) {
                niceSubarrayCount += prefixCount.get(prefixSum - k);
            }

            // 更新
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);

        }

        return niceSubarrayCount;

    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 1, 1};

        int k = 3;

        System.out.println(numberOfSubarrays(nums, k));
    }
}
