package DynamicProgramming_4.PresentBriefly_1.前缀和.差分.差分问题.区间加法;

public class Main {

    public static int[] getModifiedArray(int length, int[][] updates) {

        int[] res = new int[length];

        // 遍历所有更新操作
        for (int[] update : updates) {

            // 解析
            int startIndex = update[0];
            int endIndex = update[1];
            int inc = update[2];

            // 在 startIndex 位置增加 inc 值
            res[startIndex] += inc;

            // 在 endIndex + 1 位置减少 inc 值
            if (endIndex + 1 < length) {
                res[endIndex + 1] -= inc;
            }
        }

        // 最终的值计算到 result 数组中
        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }

        return res;
    }

    public static void main(String[] args) {

        int length = 5;

        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};

        for (int i : getModifiedArray(length, updates)) {

            System.out.print(i + " ");
        }

    }
}
