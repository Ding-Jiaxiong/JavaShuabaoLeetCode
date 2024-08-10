package DynamicProgramming_4.PresentBriefly_1.前缀和.运算推广.运算推广问题_前缀异或.子数组异或查询;

public class Main {

    public static int[] xorQueries(int[] arr, int[][] queries) {

        // 前缀异或数组
        int n = arr.length;

        int q = queries.length;

        int[] prefixXor = new int[n + 1]; // 前缀 xor 数组

        // 计算前缀异或数组
        for (int i = 0; i < n; i++) {
            prefixXor[i + 1] = prefixXor[i] ^ arr[i];
        }

        int[] res = new int[q];

        // 对每个查询
        for (int i = 0; i < q; i++) {

            int Li = queries[i][0];
            int Ri = queries[i][1];

            res[i] = prefixXor[Ri + 1] ^ prefixXor[Li];
        }

        return res;

    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};

        for (int query : xorQueries(arr, queries)) {

            System.out.print(query + " ");
        }

    }
}
