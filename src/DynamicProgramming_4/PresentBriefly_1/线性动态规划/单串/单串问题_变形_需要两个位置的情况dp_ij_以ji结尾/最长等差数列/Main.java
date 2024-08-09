package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_变形_需要两个位置的情况dp_ij_以ji结尾.最长等差数列;

import java.util.HashMap;
import java.util.Map;

public class Main {

//    public static int longestArithSeqLength(int[] nums) {
//
//        int n = nums.length;
//
//        int maxLength = 2;  // 最小长度就是 2，默认两个数肯定是个等差数列【题给用例不会有重复数出现】
//
//        int[][] dp = new int[n][n];   // dp[i][j] 表示以 nums[i] 和 nums[j] 作为最后两个元素的最长等差子序列的长度
//
//        // 遍历所有元素
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//
//                int diff = nums[i] - nums[j];  // 当前元素和前一个元素的差值
//
//                dp[i][j] = 2;  // 初始化长度是2，至少也包括 nums[i] 和 nums[j]
//
//                // 在之前的元素中寻找于当前差值相同的子序列
//                for (int k = 0; k < j; k++) {
//                    if (nums[j] - nums[k] == diff) {
//                        dp[i][j] = dp[j][k] + 1;
//                        break;
//                    }
//                }
//
//                maxLength = Math.max(maxLength, dp[i][j]); // 更新最大长度
//            }
//        }
//
//
//        return maxLength;
//    }

    public static int longestArithSeqLength(int[] nums) {

        int n = nums.length;

        int maxLength = 2;  // 默认最小长度就是 2

        Map<Integer, Integer>[] dp = new HashMap[n];  // Map 数组，每个元素存储以当前元素结尾的等差子序列信息

        for (int i = 0; i < n; i++) {

            dp[i] = new HashMap<>();   // 初始化当前元素对应的 map

            for (int j = 0; j < i; j++) {

                int diff = nums[i] - nums[j];  // 计算当前元素与前一个元素之间的差值

                int length = dp[j].getOrDefault(diff, 1) + 1; // 获取以nums[j]为结尾的、差值为diff的子序列长度，并加1

                dp[i].put(diff, length);  // 更新以nums[i]为结尾、差值为diff的子序列长度

                maxLength = Math.max(maxLength, length);  // 更新结果
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] nums = {22, 8, 57, 41, 36, 46, 42, 28, 42, 14, 9, 43, 27, 51, 0, 0, 38, 50, 31, 60, 29, 31, 20, 23, 37, 53, 27, 1, 47, 42, 28, 31, 10, 35, 39, 12, 15, 6, 35, 31, 45, 21, 30, 19, 5, 5, 4, 18, 38, 51, 10, 7, 20, 38, 28, 53, 15, 55, 60, 56, 43, 48, 34, 53, 54, 55, 14, 9, 56, 52};

        System.out.println(longestArithSeqLength(nums));

    }
}
