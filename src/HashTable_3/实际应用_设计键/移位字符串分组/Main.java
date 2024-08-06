package HashTable_3.实际应用_设计键.移位字符串分组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static String getShiftKey(String str) {

        if (str.length() == 1) return "single";  // 单个字符的一定是移位字符串，而且是一组

        StringBuilder key = new StringBuilder(); // 【构建移位键】

        int base = str.charAt(0); // 用第一个字符做一个基准

        for (int i = 1; i < str.length(); i++) {

            int shift = str.charAt(i) - base; // 当前字符与第一个字符之间的移位值

            if (shift < 0) shift += 26;  // 处理循环情况，确保 shift 为正值

            key.append(shift).append(',');
        }

        return key.toString();
    }

    public static List<List<String>> groupStrings(String[] strings) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String string : strings) {

            // 如果属于同一序列下的话
            String key = getShiftKey(string);

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(string);
        }

        // String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        // 最后的map 是这样的
        // {"single": ["a", "z"], "1,2,": ["abc", "bcd", "xyz"], "25, ": ["az", "ba"], "2,4,5,": ["acef"]}

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};

        for (List<String> groupString : groupStrings(strings)) {
            for (String string : groupString) {
                System.out.print(string + " ");
            }
            System.out.println();
        }

    }
}
