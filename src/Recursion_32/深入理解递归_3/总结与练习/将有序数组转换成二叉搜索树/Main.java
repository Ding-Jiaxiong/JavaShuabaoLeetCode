package Recursion_32.深入理解递归_3.总结与练习.将有序数组转换成二叉搜索树;

import java.util.Arrays;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 17:44
 * */

public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        // 数组本身升序，而搜索树的特点就是左边都比根节点小，右边都比根节点大[ 像二分 ]
        // 每次都让数组中点作为根，左边所有元素作为左子树，右边同理

        if (nums.length == 0)
            return null;

        int mid = nums.length / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));

        return root;
    }

    public static void main(String[] args) {


    }
}
