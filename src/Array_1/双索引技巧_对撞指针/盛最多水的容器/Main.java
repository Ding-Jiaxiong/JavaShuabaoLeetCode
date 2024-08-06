package Array_1.双索引技巧_对撞指针.盛最多水的容器;

public class Main {

    public static int maxArea(int[] height) {

        // 双指针
        int left = 0;
        int right = height.length - 1;

        int maxres = 0;

        while (left < right) {

            // 1. 左边小于右边，用左边作为高【left ++】
            // 2  左边大于右边，用右边作为高【right --】
            maxres = height[left] < height[right] ? Math.max(maxres, (right - left) * height[left++]) : Math.max(maxres, (right - left) * height[right--]);
        }

        return maxres;

    }

    public static void main(String[] args) {

        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(nums));

    }
}
