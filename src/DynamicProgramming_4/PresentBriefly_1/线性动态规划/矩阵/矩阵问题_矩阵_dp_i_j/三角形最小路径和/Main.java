package DynamicProgramming_4.PresentBriefly_1.线性动态规划.矩阵.矩阵问题_矩阵_dp_i_j.三角形最小路径和;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();  // 三角形高度（行数）

        int[] dp = new int[n]; // dp[i] 表示 从当前行第 i 个节点出发，到达底部的最小路径和

        // 顶点值就是初始状态的最小路径和
        dp[0] = triangle.get(0).get(0);

        // 从第二行开始，向下逐行计算
        for (int i = 1; i < n; i++) {

            for (int j = i; j >= 0; j--) { // // 从后往前看，避免覆盖掉没有更新的 dp[i]

                if (j == i) {  // 当前行的最后一个元素，只能从上一行的最后一个元素移动过来
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);

                } else if (j == 0) {
                    // 对于当前行的第一个元素，它只能从上一行的第一个元素移动过来
                    dp[j] = dp[j] + triangle.get(i).get(j);
                } else {

                    // 对于当前行的中间元素，选择从上一行相邻的两个元素中较小的那个来更新最小路径和
                    dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
                }
            }
        }

        // 遍历最后一行
        int minPathSum = dp[0];

        for (int i = 1; i < n; i++) {
            minPathSum = Math.min(minPathSum, dp[i]);
        }

        return minPathSum;
    }

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> list1 = new ArrayList<Integer>() {{
            add(2);
        }};

        List<Integer> list2 = new ArrayList<Integer>() {{
            add(3);
            add(4);
        }};

        List<Integer> list3 = new ArrayList<Integer>() {{
            add(6);
            add(5);
            add(7);
        }};

        List<Integer> list4 = new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }};

        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);

        System.out.println(triangle);

        System.out.println(minimumTotal(triangle));
    }
}
