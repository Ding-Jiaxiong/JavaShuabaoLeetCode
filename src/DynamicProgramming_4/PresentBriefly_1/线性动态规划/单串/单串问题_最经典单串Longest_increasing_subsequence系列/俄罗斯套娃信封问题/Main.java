package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_最经典单串Longest_increasing_subsequence系列.俄罗斯套娃信封问题;

import java.util.Arrays;

public class Main {

//    public static int maxEnvelopes(int[][] envelopes) {  // 超时了，不行
//
//        // 预排序
//        Arrays.sort(envelopes, (a, b) -> {  // 确保不会有相同宽度的信封互相嵌套
//            if (a[0] == b[0]) {
//                return b[1] - a[1];
//            } else {
//                return a[0] - b[0];
//            }
//        });
//
//        int[] dp = new int[envelopes.length];  // dp[i] 表示前 i 个信封组成套娃的最大个数
//
//        Arrays.fill(dp, 1); // 默认就是自己一个
//
//        int res = 1;  // 默认结果也是一个
//
//        for (int i = 1; i < envelopes.length; i++) {  // 遍历每个信封
//
//            for (int j = 0; j < i; j++) { // 信封 i 前的信封
//
//                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
//
//                    dp[i] = Math.max(dp[j] + 1, dp[i]);
//                }
//            }
//
//            res = Math.max(res, dp[i]); // 更新最大值结果
//        }
//
//
//        return res;
//    }

    public static int maxEnvelopes(int[][] envelopes) {

        // 对信封的宽度进行升序排序，如果宽度相同则对高度进行降序排序
        Arrays.sort(envelopes, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e2[1] - e1[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        // 高度数组
        int[] heights = new int[envelopes.length];

        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        // 求解高度数组的最长递增子序列
        return lengthOfLIS(heights);

    }

    private static int lengthOfLIS(int[] heights) {

        int[] dp = new int[heights.length];
        int len = 0;

        for (int height : heights) {

            int i = Arrays.binarySearch(dp, 0, len, height);

            if (i < 0) {
                i = -(i + 1);
            }

            dp[i] = height;
            if (i == len) {
                len++;
            }
        }

        return len;
    }

    public static void main(String[] args) {

        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};

        System.out.println(maxEnvelopes(envelopes));

    }
}
