package Recursion_32.深入理解递归_1.总结与练习.数组中的第K个最大元素;

import java.util.Random;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 14:38
 * */

public class Main {

//    // 这不就是让手撕排序
//    public static int findKthLargest(int[] nums, int k) {
//
//        int n = nums.length;
//
//        quickSort(nums, 0, n - 1);
//
//        return nums[n - k];
//    }
//
//    private static void quickSort(int[] nums, int low, int high) {
//
//        if (low >= high) return;  // 终止
//
//        int mid = partition(nums, low, high);  // 分区操作
//
//        quickSort(nums, low, mid - 1);  // 递归排序左边部分
//        quickSort(nums, mid + 1, high);  // 递归排序右边部分
//
//    }
//
//
//    public static int partition(int[] nums, int low, int high) {
//
//        int key = nums[low]; // 用第一个元素作为基准
//
//        while (low < high) {
//
//            // 右到左 寻找比基准小的元素
//            while (low < high && nums[high] >= key) high--;
//
//            nums[low] = nums[high];  // 小的元素移到左侧
//
//            // 左到右 寻找比基准大的元素
//            while (low < high && nums[low] <= key) low++;
//            nums[high] = nums[low];  // 大的元素移到右侧
//        }
//
//        nums[low] = key; // 基准元素放到中间
//
//        return low;
//    }

    // 堆排序
    public static int findKthLargest(int[] nums, int k) {

        int heapSize = nums.length;  // 堆大小初始化为数组长度

        buildMaxHeap(nums, heapSize);  // 构建大顶堆

        // 依次取出，取 k - 1次
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {

            swap(nums, 0, i);  // 堆顶元素（最大值）与当前数组的最后一个元素交换

            heapSize--; // 减小堆的大小，相当于从堆中移除最大值

            maxHeapify(nums, 0, heapSize);  // 调整堆
        }

        return nums[0];  // 返回堆顶元素，即第k大的元素
    }

    private static void buildMaxHeap(int[] nums, int heapSize) {

        // 从堆中间开始，保证大顶堆
        for (int i = heapSize / 2; i >= 0; i--) {

            maxHeapify(nums, i, heapSize);
        }
    }

    // 调整对，保证最大堆性质
    private static void maxHeapify(int[] nums, int i, int heapSize) {

        // 当前节点i的左子节点l和右子节点r的索引
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        int largest = i;

        // 如果左子节点存在且大于当前节点，更新largest为左子节点的索引
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }

        // 如果右子节点存在且大于当前节点或左子节点，更新largest为右子节点的索引
        if (right < heapSize && nums[right] > nums[largest]) {

            largest = right;
        }

        // 如果largest发生变化，说明需要交换节点i与largest节点，并递归调整受影响的子堆
        if (largest != i) {
            swap(nums, i, largest); // 交换

            maxHeapify(nums, largest, heapSize);  // 递归调整
        }
    }

    private static void swap(int[] nums, int i, int j) {

        int tmp = nums[i];
        nums[i] = nums[j];

        nums[j] = tmp;
    }


    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};

        int k = 2;

        System.out.println(findKthLargest(nums, k));

    }
}
