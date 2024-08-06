package ArrayAndString_2.双指针技巧.数组拆分;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static int arrayPairSum(int[] nums) {

        // 思维: 要使得min 的和最大，如果 6 是数组中最大的数，他肯定就算不进结果，要用一个和他最相近的小一点(或者相等)的数来中和掉它
        // 所以，排序，然后取偶数下标的
        Arrays.sort(nums);

        int res = 0;

        for (int i = 0; i < nums.length; i += 2) {

            res += nums[i];
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 4, 3, 2};

        System.out.println(arrayPairSum(nums));

    }
}
