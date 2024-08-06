package HashTable_3.小结与讨论.无重复字符的最长子串;

import java.util.HashSet;

public class Main {

    public static int lengthOfLongestSubstring(String s) {

        // 滑动窗口
        int left = 0;
        int right = 0;

        HashSet<Character> set = new HashSet<>();

        int res = 0;  // 最大长度

        while (right < s.length()) {

            while (set.contains(s.charAt(right))) {  // 出现重复了

                set.remove(s.charAt(left));  // 窗口右滑
                left++;
            }

            set.add(s.charAt(right));

            res = Math.max(res, right - left + 1);

            right++;
        }


        return res;

    }

    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }
}
