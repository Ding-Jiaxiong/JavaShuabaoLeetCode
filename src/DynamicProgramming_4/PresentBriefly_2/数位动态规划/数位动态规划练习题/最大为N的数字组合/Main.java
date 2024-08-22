package DynamicProgramming_4.PresentBriefly_2.数位动态规划.数位动态规划练习题.最大为N的数字组合;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/22 16:43
 * */

public class Main {

    public static int atMostNGivenDigitSet(String[] digits, int n) {

        String strn = String.valueOf(n);  // 数字转为字符串

        int len = strn.length();  // 整数 n 的位数长度
        int digitLen = digits.length;  // 数字数组的长度

        int res = 0;

        // 位数 比 n 少
        for (int i = 1; i < len; i++) {

            res += Math.pow(digitLen, i);  // 每一位都有 digitLen 个可能的数字
        }

        // 逐位比较
        for (int i = 0; i < len; i++) {

            boolean cur = false;  // 当前位是否有相同数字

            for (String digit : digits) {

                if (digit.charAt(0) < strn.charAt(i)) {  // 当前位的 digit 小于 n 中对应的位

                    res += Math.pow(digitLen, len - i - 1);  //
                } else if (digit.charAt(0) == strn.charAt(i)) { // 找到相同数字，继续下一位

                    cur = true;
                    break;
                }
            }

            if (!cur) { // 当前位没有找到相同数字
                return res;
            }
        }

        return res + 1;  // 加上自身
    }

    public static void main(String[] args) {

        String[] digits = {"1", "3", "5", "7"};

        int n = 100;

        System.out.println(atMostNGivenDigitSet(digits, n));

    }
}
