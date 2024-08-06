package Array_1.双索引技巧_对撞指针.两数之和II_输入有序数组;

public class Main {

    public static int[] twoSum(int[] numbers, int target) {

        // 双指针
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {  // 相遇了就结束

            if (numbers[left] + numbers[right] == target) return new int[]{left + 1, right + 1};  // 找到了返回答案
            else if (numbers[left] + numbers[right] < target) left++;  // 不够，要大点
            else right--;  // 大了

        }

        return new int[0];
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        for (int i : twoSum(nums, target)) {
            System.out.print(i + " ");
        }
    }
}
