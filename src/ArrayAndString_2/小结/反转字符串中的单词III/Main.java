package ArrayAndString_2.小结.反转字符串中的单词III;

import java.util.Collections;

public class Main {

    public static String reverseWords(String s) {

        String[] strings = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {

            char[] chars = strings[i].toCharArray();

            for (int j = chars.length - 1; j >= 0; j--) {

                sb.append(chars[j]);
            }

            if (i != strings.length - 1) {
                sb.append(" ");
            }
        }


        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "Let's take LeetCode contest";

        System.out.println(reverseWords(s));

    }
}
