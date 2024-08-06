package HashTable_3.实际应用_哈希集合.两个数组的交集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            if (set1.contains(i)) {
                res.add(i);
            }
        }

        return res.stream().mapToInt(x -> x).toArray();

    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        for (int i : intersection(nums1, nums2)) {
            System.out.print(i + " ");
        }

    }
}
