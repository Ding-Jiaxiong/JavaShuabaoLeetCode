package Array_1.双索引技巧_对撞指针.反转字符串中的元音字母;

public class Main {

    public static boolean isYuanyin(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void swap(char[] chars, int i, int j) {

        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static String reverseVowels(String s) {

        // 和回文很像，条件不同
        char[] sCharArray = s.toCharArray();

        int left = 0;
        int right = sCharArray.length - 1;

        while (left < right) {

            // 跳过非元音
            while (!isYuanyin(sCharArray[left]) && left < right) left++;
            while (!isYuanyin(sCharArray[right]) && left < right) right--;

            swap(sCharArray, left, right);

            left++;
            right--;
        }

        return String.valueOf(sCharArray);
    }

    public static void main(String[] args) {

        String s = "hello";
        System.out.println(reverseVowels(s));

    }
}
