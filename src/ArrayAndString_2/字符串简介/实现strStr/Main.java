package ArrayAndString_2.字符串简介.实现strStr;

public class Main {

    // KMP 应用，匹配子串
    public static int strStr(String haystack, String needle) {

        int m = haystack.length();
        int n = needle.length();

        // 构建 next 表
        int[] next = buildNext(needle);

        int i = 0;  // 主串指针
        int j = 0;  // 模式串指针

        while (i < m) {  // 主串匹配完毕，循环结束

            if (needle.charAt(j) == haystack.charAt(i)) {  // 当前字符匹配，继续走

                i++;
                j++;
            }

            if (j == n) {  // 模式串已经顺利看完，说明找到匹配，返回起始位置
                return i - j;
            } else if (i < m && needle.charAt(j) != haystack.charAt(i)) {  // 没有找到

                // 查 next 表
                if (j != 0) {
                    j = next[j - 1]; //
                } else { // j 还等于 0
                    i++;
                }

            }
        }

        return -1;  // 最终都没匹配成功

    }

    // 构建 next 表【根据模式串】
    public static int[] buildNext(String pattern) {

        int[] next = new int[pattern.length()];

        next[0] = 0;  // 第一个肯定是 0

        int len = 0; // 前缀长度从 0 开始
        int index = 1;

        while (index < pattern.length()) {

            if (pattern.charAt(index) == pattern.charAt(len)) {

                len++;
                next[index] = len;
                index++;
            } else {

                if (len != 0) {
                    len = next[len - 1];
                } else {
                    next[index] = 0;
                    index++;
                }

            }

        }

        return next;

    }

    public static void main(String[] args) {

        String haystack = "sadbutsad", needle = "sad";

        System.out.println(strStr(haystack, needle));

    }
}
