package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串.单串问题_最经典单串Longest_increasing_subsequence系列.最长递增子序列的个数;

import java.util.Arrays;

public class Main {

    public static int findNumberOfLIS(int[] nums) {

        int length = nums.length; // 特判
        if (length <= 1) return length;  // 其实就 1 一种情况

        int[] lengthdp = new int[length];  // lengthdp[i] 表示 在前 i 个数中【以nums[i] 结尾】最长递增子序列的长度
        int[] countsdp = new int[length];   // countsdp[i] 表示 在前 i 个数中【以nums[i] 结尾】，最长递增子序列的个数

        Arrays.fill(countsdp, 1);   // 默认有 1 个，一个数的时候【每个元素本身就是一个长度为 1 的子序列】

        for (int i = 0; i < length; i++) { // 遍历每个元素

            for (int j = 0; j < i; j++) { // 遍历当前元素之前的所有元素

                if (nums[j] < nums[i]) {  // 后一个数大于前一个数，则 nums[i] 可以 接在 nums[j] 后面行程一个递增子序列

                    if (lengthdp[j] >= lengthdp[i]) {  // 如果以 nums[j] 结尾的最长子序列长度大于等于以 nums[i] 结尾的

                        // 更新
                        lengthdp[i] = lengthdp[j] + 1;  // 长度加 1
                        countsdp[i] = countsdp[j]; // 个数变为 j 的个数
                    } else if (lengthdp[j] + 1 == lengthdp[i]) {  // 加上刚好等于，说明有多种方式到达这个长度

                        countsdp[i] += countsdp[j];
                    }
                }
            }
        }

        int longest = 0;  // 最长子序列长度
        int res = 0; // 最长子序列个数

        // 找到最长的子序列长度
        for (int len : lengthdp) {
            longest = Math.max(longest, len);
        }

        // 计算个数
        for (int i = 0; i < length; i++) {

            if (lengthdp[i] == longest) {
                res += countsdp[i];
            }
        }


        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 4, 7};

        System.out.println(findNumberOfLIS(nums));

    }
}
