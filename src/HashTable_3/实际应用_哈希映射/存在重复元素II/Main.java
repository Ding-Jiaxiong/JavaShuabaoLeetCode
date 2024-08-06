package HashTable_3.实际应用_哈希映射.存在重复元素II;

import java.util.HashMap;

public class Main {

    // 和 两数之和很像，加上了一个条件
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();  // 存数本身 和 数的索引

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {  // 已经有这个数了

                if (Math.abs(i - map.get(nums[i])) <= k) return true;
            }

            map.put(nums[i], i); // 没有就加入，有的话强行更新

        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        int k = 3;

        System.out.println(containsNearbyDuplicate(nums, k));

    }
}
