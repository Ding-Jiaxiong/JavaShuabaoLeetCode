package ArrayAndString_2.数组简介.寻找数组的中心索引;

public class Main {

    public static int pivotIndex(int[] nums) {

        // 前缀和？
        int total = 0;  // 总和
        int leftSum = 0;  // 左边的和

        for (int num : nums) {
            total += num;
        }

        for (int i = 0; i < nums.length; i++) {

            // 判断
            int rightSum = total - leftSum - nums[i];

            if (leftSum == rightSum) return i;

            leftSum += nums[i];  // 左边加上 i 这个数
        }

        return -1;  // 没找到

    }

    public static void main(String[] args) {

        int[] nums = {1, 7, 3, 6, 5, 6};

        System.out.println(pivotIndex(nums));

    }
}
