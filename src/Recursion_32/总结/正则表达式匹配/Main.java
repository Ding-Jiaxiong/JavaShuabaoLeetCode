package Recursion_32.总结.正则表达式匹配;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 19:14
 * */

public class Main {

    public static boolean isMatch(String s, String p) {

        if (p.length() == 0) return s.length() == 0; // 判空

        if (p.length() > 1 && p.charAt(1) == '*') {  // 第二位是 *

            if (isMatch(s, p.substring(2))) {  // 从 p 的第三位开始比较

                return true;
            }

            return MatchFirst(s, p) && isMatch(s.substring(1), p);
        }

        return MatchFirst(s, p) && isMatch(s.substring(1), p.substring(1));

    }

    private static boolean MatchFirst(String s, String p) {

        return s.length() > 0 && p.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
    }

    public static void main(String[] args) {

        String s = "aa", p = "a";

        System.out.println(isMatch(s, p));

    }
}
