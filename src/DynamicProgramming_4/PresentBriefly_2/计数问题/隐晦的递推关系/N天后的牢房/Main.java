package DynamicProgramming_4.PresentBriefly_2.计数问题.隐晦的递推关系.N天后的牢房;

public class Main {

    public static int[] prisonAfterNDays(int[] cells, int n) {

        // 记录循环
        boolean[] seen = new boolean[1 << 8];

        int cycle = 0; // 循环长度
        boolean hasCycle = false;

        for (int i = 0; i < n; i++) {

            int next = nextDayState(cells);

            if (seen[next]) {
                hasCycle = true;
                break;
            } else {

                seen[next] = true;
                cycle++;
            }

            cells = decodeState(next);
        }


        // 如果有循环，缩小 n 的值
        if (hasCycle) {

            n %= cycle;
            for (int i = 0; i < n; i++) {

                cells = decodeState(nextDayState(cells));
            }
        }

        return cells;
    }

    // 将整数状态解码为数组形式
    private static int[] decodeState(int state) {

        int[] cells = new int[8];

        for (int i = 0; i < 8; i++) {
            cells[i] = (state >> i) & 1;
        }

        return cells;
    }

    // 根据当前状态生成下一天的状态
    private static int nextDayState(int[] cells) {

        int state = 0;

        for (int i = 1; i < cells.length - 1; i++) {

            if (cells[i - 1] == cells[i + 1]) {
                state |= 1 << i;
            }
        }

        return state;
    }


    public static void main(String[] args) {

        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};

        int n = 7;

        for (int day : prisonAfterNDays(cells, n)) {

            System.out.print(day + " ");
        }

    }
}
