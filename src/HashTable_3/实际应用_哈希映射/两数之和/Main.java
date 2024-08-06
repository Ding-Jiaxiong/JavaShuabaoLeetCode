package HashTable_3.实际应用_哈希映射.两数之和;

import java.util.HashMap;

public class Main {

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};

    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};

        int target = 9;

        for (int i : twoSum(nums, target)) {
            System.out.print(i + " ");
        }

    }
}
