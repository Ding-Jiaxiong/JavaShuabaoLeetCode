package ArrayAndString_2.小结.杨辉三角II;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> getRow(int rowIndex) {

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < rowIndex + 1; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {

                    row.add(1);
                } else {

                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }

            }

            res.add(row);

        }

        return res.get(rowIndex);

    }

    public static void main(String[] args) {

        int rowIndex = 3;

        for (Integer i : getRow(rowIndex)) {
            System.out.print(i + " ");

        }

    }
}
