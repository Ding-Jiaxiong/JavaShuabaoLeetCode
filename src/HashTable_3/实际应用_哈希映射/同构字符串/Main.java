package HashTable_3.实际应用_哈希映射.同构字符串;

import java.util.HashMap;

public class Main {

    public static boolean isIsomorphic(String s, String t) {

        // 建立两个字符串之间每个字符的映射【唯一映射】
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char s_i = s.charAt(i);
            char t_i = t.charAt(i);

            if (mapS.containsKey(s_i)) {

                if (mapS.get(s_i) != t_i) return false;

            } else {

                if (mapT.containsKey(t_i)) {

                    if (mapT.get(t_i) != s_i) return false;
                }

                mapS.put(s_i, t_i);
                mapT.put(t_i, s_i);
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "egg", t = "add";

        System.out.println(isIsomorphic(s, t));

    }
}
