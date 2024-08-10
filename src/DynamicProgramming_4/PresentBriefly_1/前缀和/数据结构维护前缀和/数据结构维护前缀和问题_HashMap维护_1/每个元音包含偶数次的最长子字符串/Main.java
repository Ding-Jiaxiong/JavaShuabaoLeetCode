package DynamicProgramming_4.PresentBriefly_1.前缀和.数据结构维护前缀和.数据结构维护前缀和问题_HashMap维护_1.每个元音包含偶数次的最长子字符串;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static int findTheLongestSubstring(String s) {

        int maxLength = 0;  // 最长子字符串长度

        Map<Integer, Integer> vowelIndices = new HashMap<>(); // 存储元音字母最后出现的索引

        int mask = 0;  // 用于记录元音字母的奇偶次数（0 表示偶数次，1 表示奇数次）

        vowelIndices.put(0, -1);  // 空子字符串的掩码为 0，索引为 -1

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);  // 当前字符

            if (isVowel(c)) {  // 当前字符是元音字母

                mask ^= (1 << (c - 'a')); // 更新掩码

            }

            // 如果掩码之前出现过，则计算当前子字符串长度
            if (vowelIndices.containsKey(mask)) {

                maxLength = Math.max(maxLength, i - vowelIndices.get(mask));
            } else {

                vowelIndices.put(mask, i);  // 记录当前掩码的出现索引
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "eleetminicoworoep";

        System.out.println(findTheLongestSubstring(s));

    }
}
