package DynamicProgramming_4.PresentBriefly_1.前缀和.数据结构维护前缀和.数据结构维护前缀和问题_前缀和_积_与后缀和_积_均需要.找两个和为目标值且不重叠的子数组;

public class Main {

    public static int minSumOfLengths(int[] arr, int target) {

        // 要连续
        int n = arr.length; // 数组长度

        int[] prefixMin = new int[n];  // 前缀数组，prefixMin[i] 表示从开始到 i 的最小子数组长度，其和等于 target

        int[] suffixMin = new int[n];  // 后缀数组，suffixMin[i] 表示从 i 到末尾的最小子数组长度，其和等于 target

        int sum = 0;  // 前缀和
        int minLength = Integer.MAX_VALUE;  // 当前找到的最小子数组长度
        int result = Integer.MAX_VALUE;  // 最小长度和

        for (int i = 0, left = 0; i < n; i++) {

            sum += arr[i];  // 前缀和

            while (sum > target) {  // 滑动窗口

                sum -= arr[left++];  // 缩小窗口
            }

            // 如果找到了
            if (sum == target) {
                minLength = Math.min(minLength, i - left + 1);  // 更新
            }

            prefixMin[i] = minLength;
        }

        sum = 0;  // 前缀和
        minLength = Integer.MAX_VALUE;  // 当前找到的最小子数组长度 // 重置，计算后缀和

        for (int i = n - 1, right = n - 1; i >= 0; i--) {

            sum += arr[i];  // 后缀和

            // 滑动窗口
            while (sum > target) {
                sum -= arr[right--];  // 缩小窗口

            }

            // 找到了
            if (sum == target) {
                minLength = Math.min(minLength, right - i + 1);  // 更新最小长度

            }

            suffixMin[i] = minLength;
        }

        // 寻找两个不重叠的子数组的最小长度和
        for (int i = 0; i < n - 1; i++) {

            if (prefixMin[i] < Integer.MAX_VALUE && suffixMin[i + 1] < Integer.MAX_VALUE) {

                result = Math.min(result, prefixMin[i] + suffixMin[i + 1]);
            }
        }

        // result 没有被更新过，则说明没有找到满足条件的子数组
        return result == Integer.MAX_VALUE ? -1 : result;

    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 2, 4, 3};

        int target = 3;

        System.out.println(minSumOfLengths(arr, target));

    }
}
