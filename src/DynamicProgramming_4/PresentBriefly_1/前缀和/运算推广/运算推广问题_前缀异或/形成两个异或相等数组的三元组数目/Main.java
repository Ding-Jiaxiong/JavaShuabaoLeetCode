package DynamicProgramming_4.PresentBriefly_1.前缀和.运算推广.运算推广问题_前缀异或.形成两个异或相等数组的三元组数目;

public class Main {

    public static int countTriplets(int[] arr) {

        int n = arr.length;

        // 计算前缀 异或 数组
        int[] prefixXor = new int[n + 1];

        // 计算
        for (int i = 0; i < n; i++) {
            prefixXor[i + 1] = prefixXor[i] ^ arr[i];
        }

        // 结果
        int count = 0;

        // 遍历所有可能的 i、j 和 k
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j; k < n; k++) {

                    if (prefixXor[i] == prefixXor[k + 1]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 1, 6, 7};

        System.out.println(countTriplets(arr));
    }
}
