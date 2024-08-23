package Recursion_32.深入理解递归_1.总结与练习.计算右侧小于当前元素的个数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 15:13
 * */

public class Main {


    private int[] index;       // 用于存储当前元素在原数组中的索引

    private int[] temp;        // 临时数组，用于在归并排序过程中存放排序后的数组

    private int[] tempIndex;   // 临时索引数组，用于在归并排序过程中存放对应的索引

    private int[] ans;         // 用于存储每个元素右侧比该元素小的元素数量

    public List<Integer> countSmaller(int[] nums) {

        this.index = new int[nums.length];        // 初始化索引数组
        this.temp = new int[nums.length];         // 初始化临时数组
        this.tempIndex = new int[nums.length];    // 初始化临时索引数组
        this.ans = new int[nums.length];          // 初始化结果数组

        for (int i = 0; i < nums.length; ++i) {
            index[i] = i;  // 将索引数组初始化为0到n-1
        }

        int l = 0, r = nums.length - 1;

        mergeSort(nums, l, r);  // 对数组进行归并排序，并在排序过程中计算右侧比当前元素小的元素数量

        List<Integer> list = new ArrayList<Integer>();

        for (int num : ans) {   // 将结果数组转换为列表形式
            list.add(num);
        }

        return list;  // 返回最终结果
    }

    public void mergeSort(int[] a, int l, int r) {

        if (l >= r) {
            return;  // 如果左边界大于等于右边界，返回
        }

        int mid = (l + r) >> 1;  // 计算中间点

        mergeSort(a, l, mid);    // 递归对左半部分排序

        mergeSort(a, mid + 1, r); // 递归对右半部分排序

        merge(a, l, mid, r);     // 合并两部分，并计算右侧比当前元素小的元素数量
    }

    public void merge(int[] a, int l, int mid, int r) {

        int i = l, j = mid + 1, p = l;  // 初始化左右两个指针i和j，以及合并后的数组指针p

        while (i <= mid && j <= r) {    // 当左半部分和右半部分均有未处理的元素时

            if (a[i] <= a[j]) {         // 如果左侧元素小于或等于右侧元素

                temp[p] = a[i];         // 将左侧元素放入临时数组
                tempIndex[p] = index[i]; // 将左侧元素的索引放入临时索引数组
                ans[index[i]] += (j - mid - 1);  // 计算当前元素右侧比它小的元素数量
                ++i;   // 移动左侧指针
                ++p;   // 移动合并后的数组指针

            } else {

                temp[p] = a[j];         // 如果右侧元素小于左侧元素，将右侧元素放入临时数组
                tempIndex[p] = index[j]; // 将右侧元素的索引放入临时索引数组
                ++j;   // 移动右侧指针
                ++p;   // 移动合并后的数组指针
            }
        }

        while (i <= mid) {  // 当左半部分仍有剩余元素时

            temp[p] = a[i];         // 将剩余的左侧元素放入临时数组
            tempIndex[p] = index[i]; // 将剩余的左侧元素的索引放入临时索引数组
            ans[index[i]] += (j - mid - 1);  // 更新当前元素右侧比它小的元素数量
            ++i;   // 移动左侧指针
            ++p;   // 移动合并后的数组指针
        }

        while (j <= r) {  // 当右半部分仍有剩余元素时

            temp[p] = a[j];         // 将剩余的右侧元素放入临时数组
            tempIndex[p] = index[j]; // 将剩余的右侧元素的索引放入临时索引数组
            ++j;   // 移动右侧指针
            ++p;   // 移动合并后的数组指针

        }

        for (int k = l; k <= r; ++k) {  // 将临时数组的内容拷贝回原数组
            index[k] = tempIndex[k];    // 更新索引数组
            a[k] = temp[k];             // 更新原数组

        }
    }


    public static void main(String[] args) {

//        int[] nums = {5, 2, 6, 1};
//
//        for (Integer i : countSmaller(nums)) {
//            System.out.print(i + " ");
//        }

    }
}
