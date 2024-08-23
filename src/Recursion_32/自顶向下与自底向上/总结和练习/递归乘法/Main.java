package Recursion_32.自顶向下与自底向上.总结和练习.递归乘法;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 14:29
 * */

public class Main {

    public static int multiply(int A, int B) {

        if (B == 0) return 0; // 特判

        return A + multiply(A, B - 1); // 乘法 变 加法
    }

    public static void main(String[] args) {

        int a = 1;
        int b = 10;

        System.out.println(multiply(a, b));

    }
}
