package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串问题_其他单串dp_i问题.最低加油次数;

public class Main {

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {

        // 困难题
        int n = stations.length;  // 加油站数量

        long[] dp = new long[n + 1];  // dp[i] 表示加油 i 次后能到达的最远距离

        dp[0] = startFuel;  // 加 0 次，最远距离就是起始油量

        // 遍历所有加油站
        for (int i = 0; i < n; i++) {

            for (int j = i; j >= 0; j--) {

                // 如果不加油能到达当前加油站
                if (dp[j] >= stations[i][0]) {
                    // 考虑在当前加油站加油后能到达的最远距离
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }

        // 查找最小加油次数
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }

        return -1;  // 无法达到目标
    }

    public static void main(String[] args) {

        int target = 100;
        int startFuel = 10;

        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};

        System.out.println(minRefuelStops(target, startFuel, stations));
    }
}
