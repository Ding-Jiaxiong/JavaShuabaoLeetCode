package Recursion_32.深入理解递归_3.总结与练习.验证二叉搜索树;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 17:47
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

    public boolean isValidBST(TreeNode root) {

        // 典型递归
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public static boolean isValidBST(TreeNode node, long lower, long upper) {

        if (node == null)
            return true;  // 看完了，验证完毕

        if (node.val <= lower || node.val >= upper)  // 不满足
            return false;

        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);

    }

    public static void main(String[] args) {


    }
}
