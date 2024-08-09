package DynamicProgramming_4.PresentBriefly_1.线性动态规划.无串.整数拆分;

public class Main {

    public static int integerBreak(int n) {

        if (n == 2) return 1; // 只能拆分为 1 + 1
        if (n == 3) return 2; // 只能拆分为 1 + 2

        // 初始结果乘积
        int pro = 1;

        // 当 n 大于 4 时，不断拆分 3，直到剩下的 n 小于等于 4
        while (n > 4) {
            pro *= 3; // 每次将乘积乘以 3
            n -= 3; // 将 n 减去 3
        }

        pro *= n; // 最后剩下的 n 是小于等于 4 的部分，乘以最终的乘积

        return pro;
    }

    public static void main(String[] args) {

        int n = 10;

        System.out.println(integerBreak(n));

    }
}
