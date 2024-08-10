package DynamicProgramming_4.PresentBriefly_1.区间动态规划.回文相关问题.段式回文;

public class Main {

    public static int longestDecomposition(String text) {

        if (text.isEmpty()) return 0;  // 分完了


        for (int i = 1, n = text.length(); i <= n / 2; i++) {  // 从 1 开始，前缀和后缀的长度

            if (text.substring(0, i).equals(text.substring(n - i))) {  // 前缀和后缀是否相同
                return 2 + longestDecomposition(text.substring(i, n - i));  // 相同就分成两节了，然后递归
            }

        }

        return 1;  // 分不了

    }

    public static void main(String[] args) {

        String text = "ghiabcdefhelloadamhelloabcdefghi";

        System.out.println(longestDecomposition(text));

    }
}
