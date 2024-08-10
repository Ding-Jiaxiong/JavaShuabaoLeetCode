package DynamicProgramming_4.PresentBriefly_1.区间动态规划.区间动态规划其他问题.戳气球;

public class Main {

    public static int maxCoins(int[] nums) {

        int n = nums.length;

        int[] newNums = new int[n + 2];  // 新数组，增加两个边界元素（值为1） 【方便处理边界条件】

        newNums[0] = 1;
        newNums[n + 1] = 1;

        // 复制
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];  // dp[i][j]表示戳破(i, j)范围内的气球能获得的最大硬币数

        // 遍历每个区间长度
        for (int len = 2; len < n + 2; len++) {

            for (int left = 0; left < n + 2 - len; left++) {

                int right = left + len;

                // 区间 (left, right) 内最后一个被戳破的气球
                for (int i = left + 1; i < right; i++) {

                    // 当前戳破气球获得的硬币数
                    int coins = newNums[left] * newNums[i] * newNums[right];

                    // 加上戳破 (left, i) 和 (i, right) 区间内气球获得的最大硬币数
                    coins += dp[left][i] + dp[i][right];

                    // 更新 dp
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }

        // 戳破整个区间(0, n+1)的气球所能获得的最大硬币数
        return dp[0][n + 1];
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, 5, 8};

        System.out.println(maxCoins(nums));

    }
}
