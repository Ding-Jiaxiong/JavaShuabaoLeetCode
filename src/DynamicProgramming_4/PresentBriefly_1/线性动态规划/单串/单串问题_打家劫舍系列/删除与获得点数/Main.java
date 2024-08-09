package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_打家劫舍系列.删除与获得点数;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int deleteAndEarn(int[] nums) {

        // 一眼感觉要维护两个 dp
        Map<Integer, Integer> pointMap = new HashMap<>();  // 每个数字的点数总和

        int maxNum = 0;  // 数组中的最大数字

        for (int num : nums) {
            pointMap.put(num, pointMap.getOrDefault(num, 0) + num);
            maxNum = Math.max(maxNum, num);
        }

        int[] dp = new int[maxNum + 1];  // 数字不会有0, dp[i] 就表示点数为 i 的元素的能获得点数总和

        dp[1] = pointMap.getOrDefault(1, 0);

        for (int i = 2; i <= maxNum; i++) {  // 对于每个数字，要么不选当前数字，要么选

            // dp[i - 1] 就是不选当前数字
            /*
               如果选上当前数字，就不能选 [i - 1] 这个数字，得往前走
             */
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + pointMap.getOrDefault(i, 0));
        }

        return dp[maxNum];
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 2};

        System.out.println(deleteAndEarn(nums));

    }
}
