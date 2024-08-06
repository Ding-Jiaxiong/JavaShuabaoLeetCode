package ArrayAndString_2.字符串简介.最长公共前缀;

public class Main {

    public static String longestCommonPrefix(String[] strs) {

        String ret = strs[0];   // 用第一个字符串作为基准

        for (int i = 1; i < strs.length; i++) {

            while (!strs[i].startsWith(ret)) {  // 不是以第一个字符串开头

                if (ret.length() == 0) return "";  // 特判，ret 长度已经为 0 了，没有公共前缀

                ret = ret.substring(0, ret.length() - 1); // 切出子串再进行比较
            }

        }

        return ret;

    }

    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(strs));

    }
}
