package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串问题_变形_需要两个位置的情况dp_ij_以ji结尾.最长的斐波那契数子序列的长度;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int lenLongestFibSubseq(int[] arr) {

        int n = arr.length;

        Map<Integer, Integer> indexMap = new HashMap<>();  // 存储每个元素及其对应的索引

        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);  // 键是值，值是索引
        }

        int[][] dp = new int[n][n]; // dp[i][j] 表示以 arr[i] 和 arr[j] 为最后两个元素的斐波那契子序列的长度

        int maxLen = 0;  // 最长的斐波那契子序列的长度

        // 遍历每一对 (arr[i], arr[j])
        for (int j = 2; j < n; j++) {

            for (int i = 1; i < j; i++) {

                // 查找是否存在 arr[index] 使得 arr[i] + arr[i] = arr[j]
                int index = indexMap.getOrDefault(arr[j] - arr[i], -1);

                // 索引是否有效
                if (index >= 0 && index < i) {

                    dp[i][j] = dp[index][i] + 1;  // 初始化是2，任何两个数都是可以构成一个长度为 2 的斐波那契数列的

                    // 更新最长
                    maxLen = Math.max(maxLen, dp[i][j]);
                }

            }
        }

        // 为 0 说明没找到
        // 否则 maxLen + 2, dp[j][k] 计算的长度是减去前两个元素的
        return maxLen == 0 ? 0 : maxLen + 2;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(lenLongestFibSubseq(arr));

    }
}
