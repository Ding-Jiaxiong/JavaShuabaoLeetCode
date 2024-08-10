package DynamicProgramming_4.PresentBriefly_1.前缀和.数据结构维护前缀和.数据结构维护前缀和问题_HashMap维护_1.和等于k的最长子数组长度;

import java.util.HashMap;

public class Main {

    public static int maxSubArrayLen(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSumMap = new HashMap<>(); // 键是前缀和，值是对应的最早出现的位置

        int prefixSum = 0;
        int maxLength = 0;

        // 遍历数组元素
        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i]; // 当前前缀和

            if (prefixSum == k) { // 从头到当前位置的子数组的和等于 k

                maxLength = i + 1;  // 更新最大长度
            }

            if (prefixSumMap.containsKey(prefixSum - k)) {  // 如果 HashMap 中存在 (prefixSum - k)，则说明从该位置到当前位置的子数组和为 k
                maxLength = Math.max(maxLength, i - prefixSumMap.get(prefixSum - k));
            }

            // 前缀和没有在map 中出现过
            if (!prefixSumMap.containsKey(prefixSum)) {
                prefixSumMap.put(prefixSum, i);
            }
        }


        return maxLength;
    }

    public static void main(String[] args) {

        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;

        System.out.println(maxSubArrayLen(nums, k));
    }
}
