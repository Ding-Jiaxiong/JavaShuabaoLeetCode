package HashTable_3.小结与讨论.常数时间插入删除和获取随机元素;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {


    static class RandomizedSet {
        // 哈希表应用题

        int[] nums = new int[200010];
        Random random = new Random();

        Map<Integer, Integer> map = new HashMap<>();
        int index = -1;

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;

            nums[++index] = val;
            map.put(val, index);

            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;

            int loc = map.remove(val);
            if (loc != index) map.put(nums[index], loc);

            nums[loc] = nums[index--];

            return true;
        }

        public int getRandom() {
            return nums[random.nextInt(index + 1)];
        }
    }

    public static void main(String[] args) {

        RandomizedSet randomizedSet = new RandomizedSet();

        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));

        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
}
