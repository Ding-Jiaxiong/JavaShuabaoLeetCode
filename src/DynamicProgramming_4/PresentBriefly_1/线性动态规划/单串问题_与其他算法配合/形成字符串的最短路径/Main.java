package DynamicProgramming_4.PresentBriefly_1.线性动态规划.单串问题_与其他算法配合.形成字符串的最短路径;

public class Main {

//    public static int shortestWay(String source, String target) {
//
//        int count = 0; // 记录需要的子序列的数量
//        int targetIndex = 0;  // 遍历 target 的指针
//
//        while (targetIndex < target.length()) {
//
//            int sourceIndex = 0;  // 遍历 source 的指针
//            int preIndex = targetIndex;  // 目标字符串的初始位置
//
//            // 尝试在 source 中匹配 target 中的字符
//            while (sourceIndex < source.length() && targetIndex < target.length()) {
//
//                if (source.charAt(sourceIndex) == target.charAt(targetIndex)) {
//                    targetIndex++;
//                }
//
//                sourceIndex++;
//            }
//
//            // 如果 targetIndex 没有动过，说明 source 无法提供更多匹配
//            if (preIndex == targetIndex) {
//                return -1;
//            }
//
//            count++;
//        }
//
//        return count;
//    }

    public static int shortestWay(String source, String target) {

        // 双指针
        int count = 0;  // 需要的子序列数量

        int targetIndex = 0;  // 遍历 target 的指针

        while (targetIndex < target.length()) {

            int sourceIndex = 0; // 遍历 source 的指针
            int start = targetIndex;  // 记录目标字符串中当前位置的开始

            // 尝试匹配
            while (sourceIndex < source.length() && targetIndex < target.length()) {

                if (source.charAt(sourceIndex) == target.charAt(targetIndex)) {
                    targetIndex++;  // 找到匹配字符
                }

                sourceIndex++;
            }

            if (start == targetIndex) {
                // 没有移动
                return -1;
            }

            count++;
        }


        return count;
    }


    public static void main(String[] args) {

        String source = "abc";
        String target = "abcbc";

        System.out.println(shortestWay(source, target));
    }
}
