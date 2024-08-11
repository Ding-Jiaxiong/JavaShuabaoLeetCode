package DynamicProgramming_4.PresentBriefly_2.背包动态规划.最值问题.一和零;

public class Main {

    public static int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1]; // dp[i][j] 表示最多有 i 个 0 和 j 个 1 的最大子集长度

        for (String str : strs) {

            //  计算当前字符串中 0 和 1 的个数
            int[] count = countZerosOnes(str);

            int zeros = count[0];
            int ones = count[1];

            // 遍历 dp 数组, 从后向前避免重复计算
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {

                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }


        return dp[m][n]; // 满足条件的最大子集长度
    }

    private static int[] countZerosOnes(String str) {

        int[] count = new int[2];

        for (char c : str.toCharArray()) {

            if (c == '0') count[0]++;
            else count[1]++;
        }

        return count;
    }

    public static void main(String[] args) {

        String[] strs = {"10", "0001", "111001", "1", "0"};

        int m = 5;
        int n = 3;

        System.out.println(findMaxForm(strs, m, n));
    }
}
