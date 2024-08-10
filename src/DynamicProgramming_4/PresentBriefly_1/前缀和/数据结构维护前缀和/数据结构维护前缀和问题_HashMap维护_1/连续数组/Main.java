package DynamicProgramming_4.PresentBriefly_1.前缀和.数据结构维护前缀和.数据结构维护前缀和问题_HashMap维护_1.连续数组;

import java.util.HashMap;

public class Main {

    public static int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>(); // 键是前缀和，值是第一次出现的索引

        map.put(0, -1);  // 前缀和为0的情况，索引为-1

        int maxLength = 0;  // 最长子数组长度

        int count = 0;  // 前缀和

        for (int i = 0; i < nums.length; i++) {

            count += (nums[i] == 1) ? 1 : -1;   // 如果当前元素是1，前缀和加1；如果是0，前缀和减1

            if (map.containsKey(count)) {  // 如果这个前缀和已经存在于HashMap中，说明从之前的位置到当前位置有相同数量的0和1

                maxLength = Math.max(maxLength, i - map.get(count));
            } else {

                // 这个前缀和是第一次出现，则记录下这个前缀和对应的索引
                map.put(count, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] nums = {0, 1};

        System.out.println(findMaxLength(nums));

    }
}
