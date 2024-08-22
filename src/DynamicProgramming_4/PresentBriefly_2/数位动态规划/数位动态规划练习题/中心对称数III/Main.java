package DynamicProgramming_4.PresentBriefly_2.数位动态规划.数位动态规划练习题.中心对称数III;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/22 16:50
 * */

public class Main {

    // 中心对称
    private static final List<String> PAIRS = Arrays.asList("00", "11", "69", "96", "88");

    public static int strobogrammaticInRange(String low, String high) {

        int count = 0;  // 结果

        for (int len = low.length(); len <= high.length(); len++) {

            // 生成指定长度的中心对称数
            List<String> stroboNumbers = findStrobogrammatic(len, len);

            // 去除前导零判断
            for (String num : stroboNumbers) {

                if ((num.length() == low.length() && num.compareTo(low) < 0) || (num.length() == high.length() && num.compareTo(high) > 0)) {
                    continue;
                }

                count++;
            }
        }


        return count;
    }

    private static List<String> findStrobogrammatic(int curLen, int targetLen) {

        if (curLen == 0) return new ArrayList<>(Arrays.asList(""));

        if (curLen == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));

        List<String> previousStroboNumbers = findStrobogrammatic(curLen - 2, targetLen);

        List<String> stroboNumbers = new ArrayList<>();

        for (String num : previousStroboNumbers) {

            for (String pair : PAIRS) {

                // 不生成长度大于 1 的以 0 开头的数字
                if (curLen != targetLen || !pair.equals("00")) {
                    stroboNumbers.add(pair.charAt(0) + num + pair.charAt(1));
                }
            }
        }

        return stroboNumbers;
    }

    public static void main(String[] args) {

        String low = "50";
        String high = "100";

        System.out.println(strobogrammaticInRange(low, high));

    }
}
