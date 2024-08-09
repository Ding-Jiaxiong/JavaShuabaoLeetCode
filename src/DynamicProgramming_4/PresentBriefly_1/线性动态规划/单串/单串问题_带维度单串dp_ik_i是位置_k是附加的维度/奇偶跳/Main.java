package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_带维度单串dp_ik_i是位置_k是附加的维度.奇偶跳;

import java.util.Stack;
import java.util.TreeMap;

public class Main {

    public static int oddEvenJumps(int[] nums) {
        int N = nums.length;  // 获取数组的长度

        // 使用 TreeMap 来存储值及其对应的索引
        TreeMap<Integer, Integer> index = new TreeMap<>();

        // 用于记录从每个位置开始的奇跳或偶跳是否可行的数组
        boolean[] odd = new boolean[N];
        boolean[] even = new boolean[N];

        // 最后一个位置总是一个良好的起点
        odd[N - 1] = true;
        even[N - 1] = true;

        // 将最后一个元素添加到 TreeMap 中
        index.put(nums[N - 1], N - 1);

        // 从倒数第二个元素开始遍历到第一个元素
        for (int i = N - 2; i >= 0; i--) {
            int v = nums[i];

            // 如果当前值在 TreeMap 中存在
            if (index.containsKey(v)) {
                // 通过 TreeMap 获取下一个跳跃的索引来设置奇跳和偶跳的布尔值
                odd[i] = even[index.get(v)];
                even[i] = odd[index.get(v)];
            } else {
                try {
                    // 尝试获取比当前值大的最小键
                    Integer higher = index.higherKey(v);
                    if (higher != null) {
                        odd[i] = even[index.get(higher)];
                    }
                } catch (NullPointerException e) {
                    // 忽略异常
                }
                try {
                    // 尝试获取比当前值小的最大键
                    Integer lower = index.lowerKey(v);
                    if (lower != null) {
                        even[i] = odd[index.get(lower)];
                    }
                } catch (NullPointerException e) {
                    // 忽略异常
                }
            }
            // 将当前值及其索引放入 TreeMap 中
            index.put(v, i);
        }

        // 计算能通过奇跳到达结尾的起点数量
        int count = 0;
        for (boolean b : odd) {
            if (b) count++;
        }

        return count;  // 返回结果
    }

    public static void main(String[] args) {

        int[] A = {10, 13, 12, 14, 15};

        System.out.println(oddEvenJumps(A));

    }
}
