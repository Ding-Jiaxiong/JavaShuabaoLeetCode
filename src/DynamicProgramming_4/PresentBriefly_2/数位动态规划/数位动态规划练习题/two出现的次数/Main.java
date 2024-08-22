package DynamicProgramming_4.PresentBriefly_2.数位动态规划.数位动态规划练习题.two出现的次数;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/22 18:22
 * */

public class Main {

    public static int numberOf2sInRange(int n) {

        long mulk = 1;  // 分割数字

        int res = 0;  // 结果

        // 遍历每个数位
        for (int k = 0; n >= mulk; k++) {

            // 当前数位上 2 出现的次数
            // 公式
            res += (n / (mulk * 10) * mulk + Math.min(Math.max(n % (mulk * 10) - 2 * mulk + 1, 0), mulk));

            mulk *= 10; // 增加 k 值，继续计算下一个数位
        }


        return res;
    }

    public static void main(String[] args) {

        int n = 25;

        System.out.println(numberOf2sInRange(n));

    }
}
