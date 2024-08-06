package ArrayAndString_2.字符串简介.翻转字符串里的单词;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static String reverseWords(String s) {

        String[] strings = s.trim().split("\\s+");

        Collections.reverse(Arrays.asList(strings));

        return String.join(" ", strings);
    }

    public static void main(String[] args) {

        String s = "the sky is blue";

        System.out.println(reverseWords(s));
    }
}
