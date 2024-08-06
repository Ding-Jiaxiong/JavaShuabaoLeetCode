package HashTable_3.实际应用_哈希集合.快乐数;

import java.util.HashSet;

public class Main {

    public static int getNext(int n) {

        int totalSum = 0;

        while (n > 0) {

            int d = n % 10;
            n = n / 10;

            totalSum += d * d;
        }

        return totalSum;
    }

    public static boolean isHappy(int n) {

        // 使用哈希集合存储计算过的结果
        HashSet<Object> computed = new HashSet<>();

        while (n != 1 && !computed.contains(n)) {

            computed.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    public static void main(String[] args) {

        int n = 19;

        System.out.println(isHappy(n));

    }
}
