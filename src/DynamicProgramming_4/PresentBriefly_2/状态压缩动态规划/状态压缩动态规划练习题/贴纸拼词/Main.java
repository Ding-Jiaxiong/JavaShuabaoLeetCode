package DynamicProgramming_4.PresentBriefly_2.状态压缩动态规划.状态压缩动态规划练习题.贴纸拼词;

import java.util.*;

public class Main {

    public static int minStickers(String[] stickers, String target) {

        int m = target.length(); // 目标字符串的长度

        int[] memo = new int[1 << m]; // 动态规划数组，大小为2^m

        Arrays.fill(memo, -1); // 初始化为-1，表示尚未计算
        memo[0] = 0; // 空字符串的最小贴纸数为0

        int res = dp(stickers, target, memo, (1 << m) - 1); // 从全选状态开始计算

        return res <= m ? res : -1; // 如果得到的结果小于等于目标长度，则返回结果，否则返回-1

    }

    private static int dp(String[] stickers, String target, int[] memo, int mask) {

        int m = target.length(); // 目标字符串的长度

        if (memo[mask] < 0) { // 如果当前状态尚未计算过

            int res = m + 1; // 初始化结果为目标长度+1（一个不可能的结果）

            for (String sticker : stickers) { // 遍历每一个贴纸

                int left = mask; // 当前状态的mask

                int[] cnt = new int[26]; // 记录当前贴纸中每个字母的数量

                for (int i = 0; i < sticker.length(); i++) {
                    cnt[sticker.charAt(i) - 'a']++; // 更新贴纸中字母的数量
                }

                for (int i = 0; i < target.length(); i++) { // 遍历目标字符串中的每一个字符
                    char c = target.charAt(i); // 当前字符
                    if (((mask >> i) & 1) == 1 && cnt[c - 'a'] > 0) { // 如果当前字符需要且贴纸中有此字符
                        cnt[c - 'a']--; // 使用一个字符
                        left ^= 1 << i; // 更新mask，去掉当前字符
                    }
                }
                if (left < mask) { // 如果当前状态mask已经变化
                    res = Math.min(res, dp(stickers, target, memo, left) + 1); // 递归计算新的mask状态的最小贴纸数，并更新结果
                }
            }

            memo[mask] = res; // 记录计算结果到memo数组中
        }

        return memo[mask]; // 返回当前mask状态的最小贴纸数
    }

    public static void main(String[] args) {

        String[] stickers = {"with", "example", "science"};

        String target = "thehat";

        System.out.println(minStickers(stickers, target));
    }
}
