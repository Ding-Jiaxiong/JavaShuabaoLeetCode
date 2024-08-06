package HashTable_3.小结与讨论.宝石与石头;


import java.util.HashSet;

public class Main {

    public static int numJewelsInStones(String jewels, String stones) {

        // 真正的宝石
        HashSet<Character> real = new HashSet<>();

        int res = 0;

        char[] chars = jewels.toCharArray();

        for (char c : chars) {
            real.add(c);
        }

        for (int i = 0; i < stones.length(); i++) {

            if (real.contains(stones.charAt(i))) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        String jewels = "aA";
        String stones = "aAAbbbb";

        System.out.println(numJewelsInStones(jewels, stones));

    }
}
