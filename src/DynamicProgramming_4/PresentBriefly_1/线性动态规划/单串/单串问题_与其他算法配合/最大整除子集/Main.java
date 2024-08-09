package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_与其他算法配合.最大整除子集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);  // 后一个数能够严格小于前一个

        int[] dp = new int[nums.length];  // dp[i] 表示以 nums[i] 结尾的最大整除子集的大小

        Arrays.fill(dp, 1);  // 默认都是 1 个【每个元素自身可以构成一个子集】

        int[] prev = new int[nums.length];  // prev[i] 用于存储前一个能够整除 nums[i] 的元素的索引

        Arrays.fill(prev, -1);  // 表示没有前驱元素

        int maxSize = 1;  // 最大子集的大小，默认 1 个
        int maxIndex = 0;  // 最大子集的最后一个元素的索引，初始为 第一个元素

        for (int i = 1; i < nums.length; i++) {  // 遍历除第一个外所有的数

            for (int j = 0; j < i; j++) {

                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) { // 比较当前元素 nums[i] 与之前的元素 nums[j]
                    dp[i] = dp[j] + 1; // 更新以 nums[i] 结尾的最大整除子集的大小
                    prev[i] = j; // 更新前驱元素的索引
                }
            }

            if (dp[i] > maxSize) {
                maxSize = dp[i];  // 更新最大结果
                maxIndex = i;
            }
        }

        // 回溯构建最大整除子集
        List<Integer> ans = new ArrayList<>();
        while (maxIndex >= 0) {
            ans.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        for (Integer integer : largestDivisibleSubset(nums)) {

            System.out.print(integer + " ");
        }
    }
}
