package Array_1.双索引技巧_对撞指针.验证回文串;

public class Main {

    public static boolean isCharacterOrNumber(char c) {

        return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
    }

    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // 跳过非字符
            while (!isCharacterOrNumber(s.charAt(left)) && left < right) left++;
            while (!isCharacterOrNumber(s.charAt(right)) && left < right) right--;

            // 判断
            if (s.charAt(left) != s.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "race a car";

        System.out.println(isPalindrome(s));
    }
}
