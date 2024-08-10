package DynamicProgramming_4.PresentBriefly_1.区间动态规划.区间动态规划其他问题.移除盒子;

public class Main {

    int[][][] dp;  // dp[i][j][k] 表示在区间 [i, j] 上，移除 k 个 boxes[i] 颜色的盒子后获得的最大得分

    public int removeBoxes(int[] boxes) {

        int length = boxes.length;

        dp = new int[length][length][length];

        return calculatePoints(boxes, 0, length - 1, 0);  // 计算整个数组 [0, length - 1] 区间内移除盒子的最大得分， k = 0 表示初始时没有额外的相同颜色的盒子
    }

    public int calculatePoints(int[] boxes, int l, int r, int k) {
        if (l > r) {  // 区间为空
            return 0;
        }

        if (dp[l][r][k] == 0) {  // 尚未计算

            int r1 = r, k1 = k;

            while (r1 > l && boxes[r1] == boxes[r1 - 1]) {  // 向左扩展 r1，直到遇到不同颜色的盒子，或者 r1 到达左边界
                r1--;
                k1++;
            }

            dp[l][r][k] = calculatePoints(boxes, l, r1 - 1, 0) + (k1 + 1) * (k1 + 1);

            for (int i = l; i < r1; i++) {  // 尝试在区间 [l, r1 - 1] 中找到与 boxes[r1] 颜色相同的盒子

                if (boxes[i] == boxes[r1]) { // 找到相同颜色的盒子，则计算移除这些盒子的得分

                    dp[l][r][k] = Math.max(dp[l][r][k], calculatePoints(boxes, l, i, k1 + 1) + calculatePoints(boxes, i + 1, r1 - 1, 0));
                }
            }
        }

        return dp[l][r][k];
    }

    public void main(String[] args) {

        int[] boxes = {1, 3, 2, 2, 2, 3, 4, 3, 1};

        System.out.println(removeBoxes(boxes));

    }
}
