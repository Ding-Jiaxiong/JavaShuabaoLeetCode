package DynamicProgramming_4.PresentBriefly_2.状态压缩动态规划.状态压缩动态规划练习题.大礼包;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        // 递归计算最小花费
        return dfs(price, special, needs, new HashMap<>());

    }

    private static int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {

        // 当前状态已经计算过
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        int minPrice = directPurchase(price, needs); // 计算直接购买每个物品的总价格

        // 遍历每个大礼包
        for (List<Integer> offer : special) {

            // 尝试使用大礼包
            List<Integer> newNeeds = new ArrayList<>();

            for (int i = 0; i < needs.size(); i++) {

                // 检查大礼包内的物品是否超过需求量
                if (offer.get(i) > needs.get(i)) {

                    newNeeds = null;
                    break;
                }

                // 计算使用大礼包后的新需求量
                newNeeds.add(needs.get(i) - offer.get(i));
            }

            // 如果新需求量有效，则递归计算并更新最小花费
            if (newNeeds != null) {
                minPrice = Math.min(minPrice, offer.get(needs.size()) + dfs(price, special, newNeeds, memo));
            }
        }

        // 将计算的结果存入缓存中
        memo.put(needs, minPrice);

        return minPrice; // 返回当前需求下的最小花费
    }

    private static int directPurchase(List<Integer> price, List<Integer> needs) {

        int total = 0;
        for (int i = 0; i < price.size(); i++) {
            total += price.get(i) * needs.get(i);
        }

        return total;
    }

    public static void main(String[] args) {

        List<Integer> price = new ArrayList<Integer>() {{
            add(2);
            add(5);
        }};

        List<List<Integer>> special = new ArrayList<List<Integer>>() {{

            add(new ArrayList<Integer>() {{
                add(3);
                add(0);
                add(5);
            }});
            add(new ArrayList<Integer>() {{
                add(1);
                add(2);
                add(10);
            }});
        }};

        List<Integer> needs = new ArrayList<Integer>() {{
            add(3);
            add(2);
        }};

        System.out.println(shoppingOffers(price, special, needs));
    }
}
