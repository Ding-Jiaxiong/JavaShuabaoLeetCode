package DynamicProgramming_4.PresentBriefly_1.前缀和.数据结构维护前缀和.数据结构维护前缀和问题_前缀和_积_与后缀和_积_均需要.除自身以外数组的乘积;

public class Main {

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;  // 数组长度

        int[] ans = new int[n];  // 结果数组

        ans[0] = 1;  // 左边没有元素，乘积默认为 1

        // 计算前缀乘积
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];  // 当前位置的前缀乘积 = 上一位置的前缀乘积 * 上一个元素的值
        }

        // 计算后缀乘积
        int suffixProduct = 1;  // 初始化后缀乘积为 1，最后一个元素的后缀没有元素

        for (int i = n - 1; i >= 0; i--) {

            ans[i] = ans[i] * suffixProduct;  // 当前位置的结果 = 前缀乘积 * 当前后缀乘积

            suffixProduct *= nums[i]; // 更新当前后缀乘积
        }



        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        for (int i : productExceptSelf(nums)) {
            System.out.print(i + " ");
        }
    }
}
