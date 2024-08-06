package HashTable_3.实际应用_哈希映射.至多包含两个不同字符的最长子串;

import java.util.HashMap;

public class Main {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {

        // 一眼滑动窗口
        int left = 0;  // 窗口左边界
        int right = 0;  // 窗口右边界

        HashMap<Character, Integer> map = new HashMap<>();

        int res = 0;  // 返回结果

        while (right < s.length()) { // 右边界遍历完毕，循环结束

            char cur = s.charAt(right);

            map.put(cur, map.getOrDefault(cur, 0) + 1);

            right++;

            while (map.size() > 2) {  // 当前窗口中的字符数已经超过 2 个

                // 就要让左边界右移了
                cur = s.charAt(left);
                map.put(cur, map.get(cur) - 1);   // 更新出现次数
                // 如果剩下 0 次，就可以 remove 了
                if (map.get(cur) == 0) map.remove(cur);

                left++;
            }

            res = Math.max(res, right - left);  // 左闭右开
        }

        return res;

    }

    public static void main(String[] args) {

        String s = "eceba";

        System.out.println(lengthOfLongestSubstringTwoDistinct(s));

    }
}
