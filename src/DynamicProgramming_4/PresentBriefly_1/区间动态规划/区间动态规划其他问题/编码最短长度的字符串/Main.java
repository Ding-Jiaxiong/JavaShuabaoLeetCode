package DynamicProgramming_4.PresentBriefly_1.区间动态规划.区间动态规划其他问题.编码最短长度的字符串;

public class Main {

    public static String encode(String s) {

        String[][] dp = new String[s.length()][s.length()];  // dp[i][j]表示s从i到j的子串的最优编码结果

        // 遍历所有可能的子串长度
        for (int len = 1; len <= s.length(); len++) {

            for (int i = 0; i + len <= s.length(); i++) {

                int j = i + len - 1;

                // 获取从 i 到 j 的子串
                String ans = s.substring(i, j + 1);

                // 初始化
                dp[i][j] = ans;

                // 如果子串长度>=5，尝试进行编码压缩

                if (len >= 5) {

                    // 查找字符串重复的位置
                    int p = (ans + ans).indexOf(ans, 1);

                    // 如果找到的p小于当前子串长度，说明有重复模式
                    if (p < ans.length()) {

                        // 计算最优编码形式，并更新dp[i][j]
                        ans = (ans.length() / p) + "[" + dp[i][i + p - 1] + "]";
                    }

                    // 尝试将字串分为两部分，并选择更优的编码形式
                    for (int k = i; k < j; k++) {

                        if (dp[i][k].length() + dp[k + 1][j].length() < ans.length()) {

                            ans = dp[i][k] + dp[k + 1][j];
                        }
                    }
                }

                // dp 存最优结果
                dp[i][j] = ans;
            }

        }


        return dp[0][s.length() - 1];

    }

    public static void main(String[] args) {

        String s = "aabcaabcd";

        System.out.println(encode(s));

    }
}
