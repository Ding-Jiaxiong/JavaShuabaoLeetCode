package Array_1.做好初始定义.删除排序数组中的重复项;

public class Main {

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 1) return 1;

        int index = 0;

        for (int dayu = 0; dayu < nums.length; dayu++) {

            if (nums[dayu] > nums[index]) {  // 其实这一步就已经能说明和前面的数不同了，直接交换

                nums[++index] = nums[dayu];  // index 处的值是不动了，要和下一个交换
            }

        }

        return index + 1; // 索引从 0 开始
    }

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println(removeDuplicates(nums));
    }
}
