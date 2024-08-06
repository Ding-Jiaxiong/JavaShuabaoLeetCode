package ArrayAndString_2.双指针技巧.反转字符串;

public class Main {

    public static void reverseString(char[] s) {

        // 双指针
        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left++;
            right--;

        }

    }

    public static void main(String[] args) {

        char[] s = {'h', 'e', 'l', 'l', 'o'};

        reverseString(s);

        for (char c : s) {
            System.out.print(c + " ");
        }

    }
}
