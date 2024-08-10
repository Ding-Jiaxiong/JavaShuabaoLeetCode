package DynamicProgramming_4.PresentBriefly_1.区间动态规划.区间动态规划其他问题.预测赢家;

public class Main {

    public static boolean predictTheWinner(int[] nums) {

        int[][] dp = new int[nums.length][nums.length];  // dp[i][j]表示在nums[i...j]区间内玩家1相对于玩家2的最大得分差

        // 初始化
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }

        // 遍历所有可能的区间长度
        for (int len = 1; len < nums.length; len++) {

            for (int i = 0; i < nums.length - len; i++) {

                int j = i + len;

                /*
                    玩家1在i到j区间内可以从两个端点选择，取nums[i]或者nums[j]
                    如果玩家1选择nums[i]，那么玩家2在剩下的区间[i+1, j]会得分最大化，玩家1的得分为 nums[i] - dp[i+1][j]
                    如果玩家1选择nums[j]，那么玩家2在剩下的区间[i, j-1]会得分最大化，玩家1的得分为 nums[j] - dp[i][j-1]
                    玩家1会选择得分最大的那个操作
                 */
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        // dp[0][n-1]的值大于或等于0，表示玩家1可以获胜或平局，返回true
        return dp[0][nums.length - 1] >= 0;

    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 2};

        System.out.println(predictTheWinner(nums));

    }
}
