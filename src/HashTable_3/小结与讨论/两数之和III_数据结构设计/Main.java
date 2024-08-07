package HashTable_3.小结与讨论.两数之和III_数据结构设计;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static class TwoSum {

        List<Integer> list;
        Map<Integer, Integer> map;

        public TwoSum() {

            list = new ArrayList<>();
            map = new HashMap<>();
        }

        public void add(int number) {

            list.add(number);
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        public boolean find(int value) {

            for (Integer num : list) {

                int complement = value - num;

                if (complement != num) {
                    if (map.containsKey(complement)) return true;
                } else {

                    if (map.get(num) > 1) return true;
                }
            }

            return false;

        }
    }

    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();

        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);

        System.out.println(twoSum.find(4));

        System.out.println(twoSum.find(7));

    }
}
