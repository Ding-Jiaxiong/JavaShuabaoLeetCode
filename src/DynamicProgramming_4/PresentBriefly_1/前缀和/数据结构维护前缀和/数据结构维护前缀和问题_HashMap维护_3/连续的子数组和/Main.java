package DynamicProgramming_4.PresentBriefly_1.前缀和.数据结构维护前缀和.数据结构维护前缀和问题_HashMap维护_3.连续的子数组和;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static boolean checkSubarraySum(int[] nums, int k) {

        if (nums.length == 1) return false;  // 长度为1 无法形成长度至少为 2 的子数组

        Map<Integer, Integer> map = new HashMap<>(); // 键是前缀和余数，值是对应的索引

        map.put(0, -1);  // 前缀和为0，索引是 -1

        int prefixSum = 0;  // 前缀和

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];  // 当前前缀和

            int mod = k == 0 ? prefixSum : prefixSum % k;  // 前缀和对k取模

            // 如果哈希表已经存在相同余数
            if (map.containsKey(mod)) {
                // 当前索引与之前记录的索引之差是否大于1
                if (i - map.get(mod) > 1) {
                    return true;  // 找到
                }
            } else {

                map.put(mod, i);  // 如果哈希表中没有相同的余数，则记录当前的余数和索引
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {23, 2, 4, 6, 7};

        int k = 6;

        System.out.println(checkSubarraySum(nums, k));

    }
}
