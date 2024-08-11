package DynamicProgramming_4.PresentBriefly_2.背包动态规划.最值问题.最后一块石头的重量II;

public class Main {

    public static int lastStoneWeightII(int[] stones) {

        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        } // 总重量

        // 转换成 0-1 背包问题
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];  // dp[j] 表示是否可以用选中的石头达到重量 j

        dp[0] = true;

        for (int stone : stones) {

            for (int j = target; j >= stone; j--) {
                dp[j] = dp[j] || dp[j - stone];
            }
        }

        // 找到最接近总重量一半的最大值
        for (int i = target; i >= 0; i--) {

            if (dp[i]) {
                // 计算并返回最后剩下的最小石头重量
                return sum - 2 * i;
            }
        }


        return 0;
    }

    public static void main(String[] args) {

        int[] stones = {2, 7, 4, 1, 8, 1};

        System.out.println(lastStoneWeightII(stones));

    }
}
