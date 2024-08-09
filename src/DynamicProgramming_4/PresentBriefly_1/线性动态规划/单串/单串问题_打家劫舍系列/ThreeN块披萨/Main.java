package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_打家劫舍系列.ThreeN块披萨;

public class Main {

    public static int maxSizeSlices(int[] slices) {

        // 困难题
        int n = slices.length / 3;  // 我能选择的披萨块数【也是必须选择的】

        // 两次 dp
        int max1 = maxSum(slices, 0, slices.length - 2, n);  // 选第一块和倒数第二块
        int max2 = maxSum(slices, 1, slices.length - 1, n);  // 选第二块和最后一块

        return Math.max(max1, max2);
    }

    private static int maxSum(int[] slices, int start, int end, int n) {

        int m = end - start + 1;  // 选择范围中的披萨块数

        int[][] dp = new int[m + 1][n + 1];  // dp[i][j] 表示前 i 块选择 j 块的最大和

        // 遍历所有
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (i == 1) {
                    dp[i][j] = slices[start + i - 1];  // 一块只能选这块
                } else if (i == 2) {
                    dp[i][j] = Math.max(slices[start + i - 1], dp[i - 1][j]); // 两块时，选择当前或者前一个
                } else {

                    // 选择当前块和前 j - 1块，或者不选当前
                    dp[i][j] = Math.max(dp[i - 1][j], slices[start + i - 1] + dp[i - 2][j - 1]);
                }
            }
        }

        // 选择 n 块的最大和
        return dp[m][n];

    }

    public static void main(String[] args) {

        int[] Pizzas = {1, 2, 3, 4, 5, 6};

        System.out.println(maxSizeSlices(Pizzas));

    }
}
