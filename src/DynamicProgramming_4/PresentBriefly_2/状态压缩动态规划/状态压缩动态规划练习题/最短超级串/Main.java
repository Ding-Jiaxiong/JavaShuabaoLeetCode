package DynamicProgramming_4.PresentBriefly_2.状态压缩动态规划.状态压缩动态规划练习题.最短超级串;

public class Main {

    public static String shortestSuperstring(String[] words) {

        int n = words.length;  // 单词数量
        int mask = 1 << n;  // 子集总数量

        // 计算每对单词之间的重叠长度
        int[][] g = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                String a = words[i];
                String b = words[j];

                int l1 = a.length();
                int l2 = b.length();

                int len = Math.min(l1, l2);

                for (int k = len; k >= 1; k--) {

                    // 从最大重叠长度开始检查
                    if (a.substring(l1 - k).equals(b.substring(0, k))) {
                        g[i][j] = k;  // 记录
                        break;
                    }
                }
            }
        }

        // dp 数组和路径记录数组
        int[][] f = new int[mask][n], p = new int[mask][n];

        for (int s = 0; s < mask; s++) {

            for (int i = 0; i < n; i++) {

                if (((s >> i) & 1) == 0) continue;  // 当前子集不包含 i

                for (int j = 0; j < n; j++) {

                    if (((s >> j) & 1) == 1) continue;  // 当前子集已包含 j

                    // 更新 f 数组和 p 数组
                    if (f[s | (1 << j)][j] <= f[s][i] + g[i][j]) {
                        f[s | (1 << j)][j] = f[s][i] + g[i][j];
                        p[s | (1 << j)][j] = i;
                    }
                }
            }
        }

        // 寻找最终结果的最大长度
        int max = f[mask - 1][0], idx = 0, last = -1, status = mask - 1;

        for (int i = 1; i < n; i++) {

            if (max < f[mask - 1][i]) {
                max = f[mask - 1][i];
                idx = i;
            }
        }

        // 根据 p 数组重建结果字符串
        String ans = "";

        while (status != 0) {

            if (last == -1) ans = words[idx];  // 第一次添加整个单词
            else ans = words[idx].substring(0, words[idx].length() - g[idx][last]) + ans;  // 添加重叠部分
            last = idx;
            idx = p[status][idx];
            status ^= (1 << last);  // 移除 last 元素

        }

        return ans;
    }


    public static void main(String[] args) {

        String[] words = {"alex", "loves", "leetcode"};

        System.out.println(shortestSuperstring(words));

    }
}
