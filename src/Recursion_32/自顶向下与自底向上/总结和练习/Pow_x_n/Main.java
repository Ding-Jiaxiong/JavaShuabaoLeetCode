package Recursion_32.自顶向下与自底向上.总结和练习.Pow_x_n;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 14:19
 * */

public class Main {

    public static double myPow(double x, int n) {

        // 处理 n 为 0 的情况
        if (n == 0) {
            return 1.0;
        }

        // 处理 n 为负数的情况，将 x 取倒数，n 取相反数
        long N = n; // 使用 long 型防止 n 取相反数时溢出
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        double currentProduct = x;

        // 迭代计算 x^n
        while (N > 0) {
            // 如果 N 是奇数，将当前的结果乘以 currentProduct
            if (N % 2 == 1) {
                result *= currentProduct;
            }
            // 更新 currentProduct 为 x 的平方
            currentProduct *= currentProduct;
            // 将 N 减半
            N /= 2;
        }

        return result;
    }

    public static void main(String[] args) {

        double x = 2.00000;

        int n = 10;

        System.out.println(myPow(x, n));

    }
}
