package Recursion_32.深入理解递归_1.总结与练习.翻转对;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 15:24
 * */

public class Main {

    public static int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0; // 如果数组为空，返回0
        }

        return reversePairsRecursive(nums, 0, nums.length - 1); // 调用递归函数
    }

    // 递归函数，计算区间 [left, right] 内的逆序对数量
    public static int reversePairsRecursive(int[] nums, int left, int right) {

        if (left == right) {
            return 0; // 如果区间只有一个元素，返回0
        } else {

            int mid = (left + right) / 2; // 计算中间位置
            int n1 = reversePairsRecursive(nums, left, mid); // 递归计算左半部分逆序对
            int n2 = reversePairsRecursive(nums, mid + 1, right); // 递归计算右半部分逆序对
            int ret = n1 + n2; // 逆序对总数是左右两部分的和

            // 首先统计下标对的数量
            int i = left; // 左半部分的起始位置
            int j = mid + 1; // 右半部分的起始位置

            while (i <= mid) {
                while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                    j++; // 找到符合条件的 j
                }
                ret += j - mid - 1; // 统计当前 i 的逆序对数量
                i++; // 移动到下一个 i
            }

            // 随后合并两个排序数组
            int[] sorted = new int[right - left + 1]; // 用于存储合并后的数组

            int p1 = left, p2 = mid + 1; // 两个指针，分别指向左半部分和右半部分

            int p = 0; // 新数组的指针

            while (p1 <= mid || p2 <= right) {

                if (p1 > mid) {
                    sorted[p++] = nums[p2++]; // 左半部分已遍历完，直接复制右半部分
                } else if (p2 > right) {
                    sorted[p++] = nums[p1++]; // 右半部分已遍历完，直接复制左半部分
                } else {
                    if (nums[p1] < nums[p2]) {
                        sorted[p++] = nums[p1++]; // 从左半部分取较小值
                    } else {
                        sorted[p++] = nums[p2++]; // 从右半部分取较小值
                    }
                }
            }

            for (int k = 0; k < sorted.length; k++) {
                nums[left + k] = sorted[k]; // 将合并后的结果复制回原数组
            }

            return ret; // 返回逆序对总数
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 2, 3, 1};

        System.out.println(reversePairs(nums));
    }
}
