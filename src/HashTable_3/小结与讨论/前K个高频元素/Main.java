package HashTable_3.小结与讨论.前K个高频元素;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();  // 键是数值，值是出现的次数 【每个数字出现的次数】

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 优先级队列【按照数字的出现次数排序】【最小堆，堆顶是出现次数最小的】
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];  // 用次数来做比较器
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {  // 遍历每个键值对

            int num = entry.getKey();  // 数值
            int count = entry.getValue(); // 出现的次数

            if (queue.size() == k) { // 队列长度已经达到 k

                if (queue.peek()[1] < count) {  // 堆顶元素的出现次数小于当前数字
                    queue.poll(); // 堆顶元素出队
                    queue.offer(new int[]{num, count});  // 当前元素入队
                }
            } else {
                queue.offer(new int[]{num, count});  // 直接入队
            }

        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};

        int k = 2;

        for (int i : topKFrequent(nums, k)) {
            System.out.print(i + " ");
        }
    }

}
