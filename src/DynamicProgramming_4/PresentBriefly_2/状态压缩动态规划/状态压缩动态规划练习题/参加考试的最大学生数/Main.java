package DynamicProgramming_4.PresentBriefly_2.状态压缩动态规划.状态压缩动态规划练习题.参加考试的最大学生数;

import java.util.Arrays;

public class Main {

    public static int maxStudents(char[][] seats) {

        int m = seats.length;  // 行数
        int n = seats[0].length; // 列数

        int[][] dp = new int[m + 1][1 << n];  // dp[row][s] 表示前 row 行中，状态为 s 时的最大学生数

        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);  // 初始化
        }

        dp[0][0] = 0;

        for (int row = 1; row <= m; row++) {

            for (int s = 0; s < (1 << n); s++) {  // 遍历 2^n 个状态

                String bs = String.format("%" + n + "s", Integer.toBinaryString(s)).replace(' ', '0'); // 状态转换为二进制字符串

                boolean ok = true;

                for (int j = 0; j < n; j++) {

                    // 不能坐在坏椅子上，也不能在同一行相邻坐
                    if ((bs.charAt(j) == '1' && seats[row - 1][j] == '#') || (j < n - 1 && bs.charAt(j) == '1' && bs.charAt(j + 1) == '1')) {

                        ok = false;
                        break;
                    }
                }

                if (!ok) {
                    dp[row][s] = -1; // 状态不合法
                    continue;
                }

                for (int last = 0; last < (1 << n); last++) { // 遍历上一行的所有状态

                    if (dp[row - 1][last] == -1) continue; // 上一行的状态不合法

                    String lbs = String.format("%" + n + "s", Integer.toBinaryString(last)).replace(' ', '0'); // 上一行状态转换为二进制字符串

                    boolean flag = true;

                    for (int j = 0; j < n; j++) {

                        // 检查上一行状态是否与当前状态冲突
                        if (lbs.charAt(j) == '1' &&
                                ((j > 0 && bs.charAt(j - 1) == '1') || (j < n - 1 && bs.charAt(j + 1) == '1'))) {

                            flag = false;
                            break;
                        }

                    }

                    if (flag) { // 如果当前状态合法

                        dp[row][s] = Math.max(dp[row][s], dp[row - 1][last] + Integer.bitCount(s)); // 更新 dp 值
                    }
                }
            }
        }

        int res = 0;

        for (int i = 0; i < (1 << n); i++) { // 在最后一行的所有状态中找出最大的
            res = Math.max(res, dp[m][i]);
        }

        return res;

    }

    public static void main(String[] args) {

        char[][] seats = {{'.', '#'}, {'#', '#'}, {'#', '.'}, {'#', '#'}, {'.', '#'}};

        System.out.println(maxStudents(seats));
    }
}
