package DynamicProgramming_4.PresentBriefly_2.数位动态规划.数位动态规划练习题.数字1的个数;

import java.util.HashMap;
import java.util.Map;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/22 17:58
 * */

public class Main {

    public static int countDigitOne(int n) {

        String s = Integer.toString(n);

        Map<String, Integer> memo = new HashMap<>();

        // 递归
        return f(s, 0, 0, true, false, memo);
    }

    private static int f(String s, int i, int cur, boolean isLimit, boolean isNum, Map<String, Integer> memo) {

        // 已经处理完
        if (i == s.length()) return cur;  // 返回结果

        // 检查缓存
        String key = i + "," + cur + "," + isLimit + "," + isNum;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }


        // 结果
        int res = 0;

        if (!isNum) {  // 还没开始形成数字

            res += f(s, i + 1, cur, false, false, memo);
        }

        // 确定当前位可以使用的数字范围
        int low = isNum ? 0 : 1;
        int up = isLimit ? s.charAt(i) - '0' : 9;

        // 遍历当前位可能的所有数字
        for (int d = low; d <= up; d++) {

            // 递归
            res += f(s, i + 1, cur + (d == 1 ? 1 : 0), isLimit && (d == up), true, memo);
        }

        // 计算结果暂存
        memo.put(key, res);

        return res;
    }

    public static void main(String[] args) {

        int n = 13;

        System.out.println(countDigitOne(n));

    }
}
