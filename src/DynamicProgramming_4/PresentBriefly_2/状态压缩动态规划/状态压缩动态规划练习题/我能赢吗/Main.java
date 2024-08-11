package DynamicProgramming_4.PresentBriefly_2.状态压缩动态规划.状态压缩动态规划练习题.我能赢吗;

import java.util.HashMap;
import java.util.Map;

public class Main {

    // 已经计算过的
    static Map<Integer, Boolean> memo;

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        // 如果目标值是 0，先手立即获胜
        if (desiredTotal == 0) return true;

        int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;  /// 所有数字总和

        if (sum < desiredTotal) return false;  // 总和小于目标值，先手必输

        // 初始
        memo = new HashMap<>();

        return canIWinHelper(maxChoosableInteger, desiredTotal, 0);  // 状态压缩
    }

    private static boolean canIWinHelper(int maxChoosableInteger, int desiredTotal, int usedNumbers) {

        // 如果目标值小于等于0，表示当前玩家已经不能再赢
        if (desiredTotal <= 0) return false;

        // 如果该局面已经计算过，直接返回结果
        if (memo.containsKey(usedNumbers)) return memo.get(usedNumbers);

        // 遍历可选数字
        for (int i = 0; i < maxChoosableInteger; i++) {

            // 当前数字对应
            int curMask = 1 << i;

            // 已经使用，跳过
            if ((usedNumbers & curMask) != 0) continue;

            // 如果选择当前数字会让对方输掉（即对方在剩余局面中无必胜策略），那么当前玩家必赢
            if (!canIWinHelper(maxChoosableInteger, desiredTotal - (i + 1), usedNumbers | curMask)) {

                // 记录
                memo.put(usedNumbers, true);
                return true;
            }
        }

        // 如果无论怎么选都会输，记录当前局面结果并返回 false
        memo.put(usedNumbers, false);

        return false;
    }


    public static void main(String[] args) {

        int maxChoosableInteger = 10, desiredTotal = 0;

        System.out.println(canIWin(maxChoosableInteger, desiredTotal));

    }
}
