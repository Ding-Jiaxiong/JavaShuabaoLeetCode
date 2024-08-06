package HashTable_3.实际应用_哈希映射.两个列表的最小索引总和;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);  // list1 全部加入 map
        }

        List<String> res = new ArrayList<>(); // 结果集

        int indexsum = Integer.MAX_VALUE;  // 要最小就设成最大

        for (int i = 0; i < list2.length; i++) {

            if (map.containsKey(list2[i])) {

                int index_andy = map.get(list2[i]);

                if (index_andy + i < indexsum) {

                    res.clear(); // 出现更优解，之前的解就不要了
                    res.add(list2[i]);

                    indexsum = index_andy + i;
                } else if (index_andy + i == indexsum) {

                    res.add(list2[i]); //
                }
            }
        }

        return res.toArray(new String[res.size()]);

    }

    public static void main(String[] args) {

        String[] andy = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] doris = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        for (String s : findRestaurant(andy, doris)) {
            System.out.print(s + " ");
        }

    }
}
