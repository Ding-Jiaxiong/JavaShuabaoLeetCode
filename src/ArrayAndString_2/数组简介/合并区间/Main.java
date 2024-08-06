package ArrayAndString_2.数组简介.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];  // 按照区间起始值排序
            }
        });

        List<int[]> mergeres = new ArrayList<>();  // 合并结果

        for (int i = 0; i < intervals.length; i++) {

            int begin = intervals[i][0];
            int end = intervals[i][1];

            // 1. 当前结果里面还没有【直接加入】
            // 2. 当前结果的最后一个区间都不够装下这个区间【直接加入】
            if (mergeres.size() == 0 || mergeres.get(mergeres.size() - 1)[1] < begin) {  // 直接加入的情况
                mergeres.add(intervals[i]);
            } else {

                // 更新
                mergeres.get(mergeres.size() - 1)[1] = Math.max(mergeres.get(mergeres.size() - 1)[1], end);
            }

        }

        return mergeres.toArray(new int[mergeres.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        for (int[] ints : merge(intervals)) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }
}
