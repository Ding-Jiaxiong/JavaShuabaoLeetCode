package DynamicProgramming_4.PresentBriefly_1.线性动态规划.双串.双串问题_最经典双串Longest_Common_Subsequence系列.最大重复子数组;

public class Main {

    public static int findLength(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m + 1][n + 1];  // dp[i][j] 表示以nums1[i-1]和nums2[j-1]结尾的最长公共子数组的长度

        int maxLength = 0;  // 结果

        // 遍历两个数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // 当前元素相等
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    // 更新最大
                    maxLength = Math.max(maxLength, dp[i][j]);
                }else{
                    dp[i][j] = 0;  // 不相等，置 0
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};

        System.out.println(findLength(nums1, nums2));

    }
}
