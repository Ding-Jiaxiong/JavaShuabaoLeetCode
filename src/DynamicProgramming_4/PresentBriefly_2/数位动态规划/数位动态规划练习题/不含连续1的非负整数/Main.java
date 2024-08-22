package DynamicProgramming_4.PresentBriefly_2.数位动态规划.数位动态规划练习题.不含连续1的非负整数;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/22 17:08
 * */

public class Main {

    public static int findIntegers(int n) {

        char[] binary = Integer.toBinaryString(n).toCharArray();  // 二进制字符数组

        int len = binary.length;

        int[][] dp = new int[len][2]; // dp[i][j] 表示当前位数为 i，前一位为 j 的情况下，不存在连续 1 的数字个数

        // 初始化
        dp[0][0] = 1; // 第一位为 0
        dp[0][1] = 1; // 第一位为 1

        // 填充
        for (int i = 1; i < len; i++) {

            dp[i][0] = dp[i - 1][0] + dp[i - 1][1]; // 当前位为 0 时，前一位可以为 0 或 1
            dp[i][1] = dp[i - 1][0];  // 当前位为 1 时，前一位只能为 0
        }

        int res = 0;

        int prevBit = 0; // 记录上一位的值

        // 逐位扫描
        for (int i = 0; i < len; i++) {

            int curBit = binary[i] - '0';  // 当前位的值

            if (curBit == 1) {
                res += dp[len - i - 1][0]; // 当前位是 1 ，则加上当前位为 0 的情况

                if (prevBit == 1) {  // 出现 连续 1

                    return res;
                }
            }

            prevBit = curBit;
        }

        return res + 1; // 包含 n 本身
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println(findIntegers(n));
    }
}
