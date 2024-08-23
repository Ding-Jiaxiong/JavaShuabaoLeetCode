package Recursion_32.总结.外观数列;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 19:19
 * */

public class Main {

    public static String countAndSay(int n) {

        // 如果 n 等于 1，则返回字符串 "1"
        if (n == 1) {
            return "1";
        }

        // 递归调用获取前一个字符串
        String BeforeStr = countAndSay(n - 1);
        // 初始化慢指针 slow 和快指针 fast
        int slow = 0;
        int fast = 0;
        // 使用 StringBuilder 来构建新的字符串
        StringBuilder sb = new StringBuilder();

        // 当快指针未遍历完字符串时
        while (fast < BeforeStr.length()) {
            // 快指针移动，直到遇到与慢指针指向字符不同的字符
            while (fast < BeforeStr.length() && BeforeStr.charAt(slow) == BeforeStr.charAt(fast)) {
                fast++;
            }
            // 计算相同字符的数量 (fast - slow)，并将其与字符一起添加到 StringBuilder 中
            sb.append(Integer.toString((fast - slow))).append(BeforeStr.charAt(slow));
            // 将慢指针移动到快指针的位置，准备处理下一个字符
            slow = fast;
        }

        // 返回构建好的字符串
        return sb.toString();

    }

    public static void main(String[] args) {

        int n = 4;

        System.out.println(countAndSay(n));

    }
}
