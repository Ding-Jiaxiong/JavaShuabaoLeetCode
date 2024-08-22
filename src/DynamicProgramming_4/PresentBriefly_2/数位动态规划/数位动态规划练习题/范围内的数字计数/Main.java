package DynamicProgramming_4.PresentBriefly_2.数位动态规划.数位动态规划练习题.范围内的数字计数;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/22 18:12
 * */

public class Main {


    public static int digitsCount(int d, int low, int high) {

        return solve(d, high) - solve(d, low - 1); // 高位减低位的方式计算区间内的出现次数
    }

    private static int solve(int d, int n) {

        long mulk = 1; // 表示 10 的 k 次方，用于分割数字
        int res = 0; // 记录数字 d 出现的次数

        // 遍历每个数位
        for (int k = 0; n >= mulk; ++k) {
            // 如果 d 不是 0，计算公式如下
            if (d != 0) {
                res += (n / (mulk * 10) * mulk + Math.min(Math.max(n % (mulk * 10) - d * mulk + 1, 0), mulk));
            }
            // 如果 d 是 0，计算公式稍有不同
            else {
                res += ((n / (mulk * 10) - 1) * mulk + Math.min(Math.max(n % (mulk * 10) - d * mulk + 1, 0), mulk));
            }

            mulk *= 10; // 增加 k 值，继续计算下一个数位
        }
        return res; // 返回 d 出现的总次数
    }

    public static void main(String[] args) {

        int d = 1;
        int low = 1;
        int high = 13;

        System.out.println(digitsCount(d, low, high));

    }
}
