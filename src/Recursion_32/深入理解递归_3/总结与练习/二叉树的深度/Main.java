package Recursion_32.深入理解递归_3.总结与练习.二叉树的深度;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 17:50
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

    public static int maxDepth(TreeNode root) {

        if (root == null) return 0;  // 递归终止

        int left_deep = maxDepth(root.left);  // 左子树最大深度
        int right_deep = maxDepth(root.right); // 右子树最大深度

        return Math.max(left_deep, right_deep) + 1;  // 加上 1
    }

    public static void main(String[] args) {

    }
}
