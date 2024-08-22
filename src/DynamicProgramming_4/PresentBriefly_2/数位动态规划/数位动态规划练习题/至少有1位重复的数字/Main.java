package DynamicProgramming_4.PresentBriefly_2.数位动态规划.数位动态规划练习题.至少有1位重复的数字;

import java.util.Arrays;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/22 17:15
 * */

public class Main {

    static char s[];
    static int memo[][];

    public static int numDupDigitsAtMostN(int n) {

        s = Integer.toString(n).toCharArray();

        int m = s.length;

        memo = new int[m][1 << 10];

        for (int i = 0; i < m; i++)
            Arrays.fill(memo[i], -1); // -1 表示没有计算过

        return n - dp(0, 0, true, false);
    }

    static int dp(int i, int mask, boolean isLimit, boolean isNum) {

        if (i == s.length)
            return isNum ? 1 : 0; // isNum 为 true 表示得到了一个合法数字

        if (!isLimit && isNum && memo[i][mask] != -1)
            return memo[i][mask];

        int res = 0;

        if (!isNum) // 可以跳过当前数位
            res = dp(i + 1, mask, false, false);

        int up = isLimit ? s[i] - '0' : 9; // 如果前面填的数字都和 n 的一样，那么这一位至多填数字 s[i]（否则就超过 n 啦）

        for (int d = isNum ? 0 : 1; d <= up; ++d) // 枚举要填入的数字 d
            if ((mask >> d & 1) == 0) // d 不在 mask 中
                res += dp(i + 1, mask | (1 << d), isLimit && d == up, true);
        if (!isLimit && isNum)

            memo[i][mask] = res;

        return res;
    }


    public static void main(String[] args) {

        int n = 20;

        System.out.println(numDupDigitsAtMostN(n));
    }
}
