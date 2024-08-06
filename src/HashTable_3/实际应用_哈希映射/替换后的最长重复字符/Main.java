package HashTable_3.实际应用_哈希映射.替换后的最长重复字符;

import java.util.HashMap;

public class Main {

    public static int characterReplacement(String s, int k) {

        int len = s.length();  // 字符串的长度

        // 特判
        if (len == 1) return len;  // 不会等于 0

        char[] charArray = s.toCharArray();

        int[] count = new int[26];  // count[0] 表示窗口中 A字符 出现的次数，以此类推

        int maxCount = 0;  // 字符串当中（替换后），字符能够出现的最大的次数

        int res = 0;

        // 滑动窗口的左右边界
        int left = 0;
        int right = 0;

        while (right < len) {  // 右边界到底，循环结束

            // 右边界看到的字符
            count[charArray[right] - 'A']++;

            maxCount = Math.max(maxCount, count[charArray[right] - 'A']);

            right++;

            if (right - left > maxCount + k) { // 不是最多出现的字符完全替换为是了之后还是无法填满整个区间，就要将左边界右移了
                count[charArray[left] - 'A']--;  // 对应的字符出现次数也要减掉
                left++;
            }

            // 更新结果
            res = Math.max(res, right - left);
        }

        return res;

    }

    public static void main(String[] args) {

        String s = "AABCABBB";

        int k = 2;

        System.out.println(characterReplacement(s, k));

    }
}
