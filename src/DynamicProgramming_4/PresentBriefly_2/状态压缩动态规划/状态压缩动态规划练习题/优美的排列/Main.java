package DynamicProgramming_4.PresentBriefly_2.状态压缩动态规划.状态压缩动态规划练习题.优美的排列;

public class Main {

    public static int countArrangement(int n) {

        // 记录每个位置是否已被使用
        boolean[] used = new boolean[n + 1];

        // 递归计算
        return countArrangementHelper(n, 1, used);
    }

    private static int countArrangementHelper(int n, int pos, boolean[] used) {

        if (pos > n) return 1;  // 所有位置都已被填满，返回 1

        int count = 0;

        // 遍历所有可能的数
        for (int num = 1; num <= n; num++) {

            //  num 未被使用且符合优美排列的条件
            if (!used[num] && (num % pos == 0 || pos % num == 0)) {

                // 标记 num 为已使用
                used[num] = true;

                // 递归计算下一位置的优美排列的数量
                count += countArrangementHelper(n, pos + 1, used);

                // 回溯
                used[num] = false;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int n = 2;

        System.out.println(countArrangement(n));

    }
}
