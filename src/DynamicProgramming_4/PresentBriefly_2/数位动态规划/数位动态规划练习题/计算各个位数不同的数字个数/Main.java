package DynamicProgramming_4.PresentBriefly_2.数位动态规划.数位动态规划练习题.计算各个位数不同的数字个数;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/22 17:00
 * */

public class Main {

    public static int countNumbersWithUniqueDigits(int n) {

        if (n == 0) return 1;  // 等于0 只有数字 0 满足条件

        int count = 10;  // 为 1 时
        int uniqueDigits = 9;  // 第一个 1- 9中选
        int availableNumber = 9;  // 剩下的 9 种

        // 2 到 n 位
        for (int i = 2; i <= n && availableNumber > 0; i++) {

            uniqueDigits *= availableNumber;  // 每多一位，选择的可能性乘以当前剩余可选数字
            count += uniqueDigits;  /// 累加

            availableNumber--;  // 可选数字 --
        }

        return count;
    }

    public static void main(String[] args) {

        int n = 2;

        System.out.println(countNumbersWithUniqueDigits(n));

    }
}
