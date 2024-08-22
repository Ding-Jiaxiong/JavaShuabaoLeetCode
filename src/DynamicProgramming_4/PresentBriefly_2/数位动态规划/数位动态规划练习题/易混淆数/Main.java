package DynamicProgramming_4.PresentBriefly_2.数位动态规划.数位动态规划练习题.易混淆数;

import java.util.HashMap;
import java.util.Map;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/22 17:32
 * */

public class Main {

    int[] nums = new int[]{0, 1, 6, 8, 9};  // 原
    int[] revs = new int[]{0, 1, 9, 8, 6};  // 反转

    int n;  // 上限
    int count = 0;   // 结果

    public int confusingNumberII(int n) {

        this.n = n;

        dfs(0, 0, 0);

        return count;

    }

    /**
     *
     * @param cur 当前构造的数字
     * @param rev 当前构造数字的反转
     * @param digit 当前数字的位数
     */
    private void dfs(int cur, int rev, int digit) {

        if (cur > this.n) {
            return;  // 大于上限，结束
        }

        if (cur != rev) {
            this.count++; // 如果当前数字不是其反转后的数字，计数加 1
        }

        // 遍历所有可能的数字
        for (int i = 0; i < 5; i++) {

            if (digit == 0 && i == 0) continue;  // 避免前导 零

            if (cur > n / 10) return;  // 当前数字大于上限的一半

            int nextCur = cur * 10 + nums[i]; // 计算下一个
            int nextRev = revs[i] * (int) (Math.pow(10, digit)) + rev;  // 下一个数字的反转

            dfs(nextCur, nextRev, digit + 1);  // 下一位

        }

    }

    public static void main(String[] args) {

        int n = 20;

//        System.out.println(confusingNumberII(n));

    }
}
