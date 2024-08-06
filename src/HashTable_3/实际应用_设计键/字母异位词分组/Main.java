package HashTable_3.实际应用_设计键.字母异位词分组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> res = new HashMap<>();

        for (String str : strs) {  // 遍历每一个字符串

            char[] chars = str.toCharArray();
            Arrays.sort(chars);  // 按字符排序

            String key = new String(chars);

            // 从 map 中取，如果没有就新建一个空列表
            List<String> list = res.getOrDefault(key, new ArrayList<>());

            // 加入当前的字符串【排序前的】
            list.add(str);

            // 更新 resmap
            res.put(key, list);
        }

        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {

        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};

        for (List<String> stringList : groupAnagrams(strings)) {
            for (String s : stringList) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }
}
