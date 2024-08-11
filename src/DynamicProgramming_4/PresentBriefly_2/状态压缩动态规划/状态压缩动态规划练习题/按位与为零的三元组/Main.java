package DynamicProgramming_4.PresentBriefly_2.状态压缩动态规划.状态压缩动态规划练习题.按位与为零的三元组;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int countTriplets(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int k = nums[i] & nums[j];

                map.put(k, map.getOrDefault(k, 0) + 1);
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            int val = nums[i];

            for (Integer v : map.keySet()) {

                if ((v & val) == 0) ans += map.get(v);

            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {2, 1, 3};

        System.out.println(countTriplets(nums));
    }
}
