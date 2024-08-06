package ArrayAndString_2.双指针技巧.两数之和II输入有序数组;

public class Main {

    public static int[] twoSum(int[] numbers, int target) {

        // 一眼双指针, 因为已经拍好序了
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int cur = numbers[left] + numbers[right];

            if (cur == target) {  // 找到了

                return new int[]{left + 1, right + 1};
            } else if (cur < target) {

                left++;
            } else {

                right--;
            }

        }

        return new int[0];  // 没找到随便返回一个数组
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};

        int target = 9;

        for (int i : twoSum(nums, target)) {
            System.out.print(i + " ");
        }

    }
}
