package HashTable_3.小结与讨论.单词的唯一缩写;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static class ValidWordAbbr {

        Map<String, String> map = new HashMap<>();

        // 哈希映射，键值都是字符串
        public ValidWordAbbr(String[] dictionary) {

            for (String string : dictionary) {

                // 键是缩写字符串，值是string 本身
                map.merge(getAbbr(string), string, (OldString, newString) -> OldString.equals(string) ? OldString : "distinct");  // 如果缩写冲突了，用distinct来表示
            }
        }

        // 获取单词缩写
        private String getAbbr(String s) {
            int len = s.length();  // 字符串长度

            return len <= 2 ? s : s.charAt(0) + String.valueOf(len - 2) + s.charAt(len - 1);
        }

        // 检查缩写是否唯一
        public boolean isUnique(String word) {

            String val = map.get(getAbbr(word));

            return val == null || val.equals(word);

        }
    }

    public static void main(String[] args) {

        ValidWordAbbr validWordAbbr = new ValidWordAbbr(new String[]{"deer", "door", "cake", "card"});

        System.out.println(validWordAbbr.isUnique("dear"));

        System.out.println(validWordAbbr.isUnique("cart"));
    }
}
