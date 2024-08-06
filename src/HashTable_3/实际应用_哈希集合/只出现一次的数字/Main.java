package HashTable_3.实际应用_哈希集合.只出现一次的数字;

public class Main {

    public static int singleNumber(int[] nums) {

        // 位运算直接秒了【相同的数已经位运算会 1 1 得 0】
        int res = 0;

        for (int num : nums) {
            res ^= num;
        }

        return res;

    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 1};

        System.out.println(singleNumber(nums));
    }
}
