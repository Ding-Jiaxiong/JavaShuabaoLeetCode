package DynamicProgramming_4.PresentBriefly_1.前缀和.数据结构维护前缀和.数据结构维护前缀和问题_前缀和_积_与后缀和_积_均需要.寻找数组的中心索引;

public class Main {

    public static int pivotIndex(int[] nums) {

        // 很明显了，前后缀和一起用【但是这里后缀和可以直接减出来】

        int sum = 0;  // 元素总和
        int leftSum = 0; // 中心左边的元素和

        // 计算元素总和
        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length; i++) {

            if (leftSum == sum - leftSum - nums[i]) return i;

            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 7, 3, 6, 5, 6};

        System.out.println(pivotIndex(nums));

    }
}
