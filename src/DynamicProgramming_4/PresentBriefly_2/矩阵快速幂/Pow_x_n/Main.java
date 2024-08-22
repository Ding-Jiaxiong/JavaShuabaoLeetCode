package DynamicProgramming_4.PresentBriefly_2.矩阵快速幂.Pow_x_n;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/22 16:28
 * */

public class Main {

    public static double myPow(double x, int n) {

        long N = n;

        if (N < 0) {
            x = 1 / x;
            N = -N;   // 如果 n 是负数，将 x 取倒数，并且 n 转为正数
        }

        // 初始化结果
        double res = 1.0;  // x 的 0 次方

        double cur = x;  // 当前幂次

        while (N > 0) {

            if (N % 2 == 1) {
                res *= cur;
            }

            cur *= cur;  // 乘方，用于下次计算

            N /= 2;
        }

        return res;
    }

    public static void main(String[] args) {

        double x = 2.00000;

        int n = 10;

        System.out.println(myPow(x, n));

    }

}
