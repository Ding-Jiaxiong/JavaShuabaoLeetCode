package DynamicProgramming_4.PresentBriefly_1.前缀和.数据结构维护前缀和.数据结构维护前缀和问题_HashMap维护_2.和为K的子数组;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int subarraySum(int[] nums, int k) {


        Map<Integer, Integer> prefixSumCount = new HashMap<>(); // 键是前缀和，值是出现次数

        prefixSumCount.put(0, 1); // 前缀和为 0 的次数默认 1 次

        int resultCount = 0;  // 和为 k 的子数组个数
        int prefixSum = 0;  // 前缀和

        for (int num : nums) {

            prefixSum += num;

            if (prefixSumCount.containsKey(prefixSum - k)) {  // 是否存在前缀和为 currentSum - k 的情况
                resultCount += prefixSumCount.get(prefixSum - k);
            }

            // 更新当前前缀和在map中的出现次数
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return resultCount;  // 返回和为k的子数组个数
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};

        int k = 2;

        System.out.println(subarraySum(nums, k));

    }
}
