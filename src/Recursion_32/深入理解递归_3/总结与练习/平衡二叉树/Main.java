package Recursion_32.深入理解递归_3.总结与练习.平衡二叉树;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 17:54
 * */

public class Main {

    public static class TreeNode {
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

    public static boolean isBalanced(TreeNode root) {

        // 简单题
        if (root == null) return true;

        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    private static int depth(TreeNode root) {

        if (root == null) return 0;

        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public static void main(String[] args) {

    }
}
