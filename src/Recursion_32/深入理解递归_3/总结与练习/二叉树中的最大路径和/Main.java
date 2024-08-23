package Recursion_32.深入理解递归_3.总结与练习.二叉树中的最大路径和;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 17:59
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

    // 初始化结果为最小整数值
    int maximun = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        // dfs
        dfs(root);

        return maximun;
    }

    private int dfs(TreeNode root) {

        // 递归结束
        if (root == null) return 0;

        // 递归左子树
        int left = Math.max(0, dfs(root.left));

        // 递归右子树
        int right = Math.max(0, dfs(root.right));

        // 更新最大路径和
        maximun = Math.max(maximun, root.val + left + right);

        // 返回
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {

    }
}
