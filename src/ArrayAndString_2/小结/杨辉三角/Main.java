package ArrayAndString_2.小结.杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<List<Integer>> generate(int numRows) {

        // 数学题，找规律
        List<List<Integer>> res = new ArrayList<>(); // 结果

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>(); // 一行的结果

            for (int j = 0; j <= i; j++) {  // 每一行有 i + 1 个数

                if (j == 0 || j == i) {
                    row.add(1);  // 开头末尾都是 1
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));   // 除了开头末尾，其他位置的数等于上一行的对应位置和前一个位置的两数和
                }
            }

            res.add(row);
        }

        return res;

    }

    public static void main(String[] args) {

        int numrows = 5;

        for (List<Integer> integers : generate(numrows)) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }
}
