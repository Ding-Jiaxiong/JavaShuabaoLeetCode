package DynamicProgramming_4.PresentBriefly_1.前缀和.数据结构维护前缀和.数据结构维护前缀和问题_HashMap维护_3.和可被K整除的子数组;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int subarraysDivByK(int[] nums, int k) {

        int prefixSumdivByKCount = 0;

        Map<Integer, Integer> map = new HashMap<>();  // 键是前缀和 mod k 的结果，值是出现次数

        map.put(0, 1);  // 前缀和为0，mok k = 0的子数组默认为 1

        int prefixSum = 0;  // 前缀和

        for (int num : nums) {

            prefixSum += num; // 更新前缀和

            int mod = (prefixSum % k + k) % k;  // 计算当前前缀和对 k 的模，确保结果为正数

            if (map.containsKey(mod)) {
                prefixSumdivByKCount += map.get(mod);  // 增加
            }

            // 更新
            map.put(mod, map.getOrDefault(mod, 0) + 1);

        }


        return prefixSumdivByKCount;

    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;

        System.out.println(subarraysDivByK(nums, k));
    }
}
