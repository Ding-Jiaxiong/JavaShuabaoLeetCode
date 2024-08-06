package Array_1.做好初始定义.删除排序数组中的重复项II;

public class Main {

    // 这道题就通用了，那个 2 可以换成保留 1 或者 保留 n 个
    public static int removeDuplicates(int[] nums) {

        if (nums.length == 1) return 1;

        int index = 0;

        for (int dayu = 0; dayu < nums.length; dayu++) { // 还是遍历整个数组

            if (index < 2 || nums[dayu] != nums[index - 2]) { // < 2 的意思其实就是绕过索引为0和索引为1 的两个数, 绕过之后，隔两个才是我们判断要不要交换的主要条件
                nums[index++] = nums[dayu];
            }

        }

        return index;

    }

    public static void main(String[] args) {


        int[] nums = {1, 2, 2, 3};

        System.out.println(removeDuplicates(nums));
    }
}
