package Array_1.做好初始定义.移除元素;

public class Main {


    public static int removeElement(int[] nums, int val) {

        // 和移动 0 很像，换 0 变成换 val，最后返回的是交换次数
        if (nums.length == 0) return 0;

        int valindex = 0;

        for (int notval = 0; notval < nums.length; notval++) {

            if (nums[notval] != val) {

                nums[valindex++] = nums[notval];
            }

        }

        return valindex;  // 实际上就是交换次数，不过这道题不用返回最后的交换结果【所以不用swap】
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 2, 3};
        int val = 3;

        System.out.println(removeElement(nums, val));

    }
}
