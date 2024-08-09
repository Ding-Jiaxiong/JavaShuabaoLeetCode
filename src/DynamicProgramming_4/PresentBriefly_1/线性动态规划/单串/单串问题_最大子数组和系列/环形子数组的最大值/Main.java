package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_最大子数组和系列.环形子数组的最大值;

public class Main {

    public static int maxSubarraySumCircular(int[] nums) {

        int maxSub = Integer.MIN_VALUE;  // 最大子数组和
        int minSub = 0; // 最小子数组和

        int maxCur = 0; // 当前最大子数组和
        int minCur = 0; // 当前最小子数组和

        int sum = 0;  // 数组总和

        for (int num : nums) {

            // 计算以 num 结尾的最大子数组和
            maxCur = Math.max(maxCur, 0) + num;
            maxSub = Math.max(maxSub, maxCur);  // 更新最大结果

            // 计算以 num 结尾的最小子数组和
            minCur = Math.min(minCur, 0) + num;
            minSub = Math.min(minSub, minCur);  // 更新最小结果

            sum += num;
        }

        // 如果sum == minS，说明数组中的所有元素都是负数，此时不能取整个数组作为子数组，返回maxS作为结果
        // 否则，返回max(maxS, sum - minS)，即在最大子数组和和整个数组减去最小子数组和之间取最大值
        return sum == minSub ? maxSub : Math.max(maxSub, sum - minSub);
    }

    public static void main(String[] args) {

        int[] nums = {1, -2, 3, -2};

        System.out.println(maxSubarraySumCircular(nums));

    }
}
