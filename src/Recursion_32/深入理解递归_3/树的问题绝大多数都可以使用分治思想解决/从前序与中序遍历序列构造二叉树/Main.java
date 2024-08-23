package Recursion_32.深入理解递归_3.树的问题绝大多数都可以使用分治思想解决.从前序与中序遍历序列构造二叉树;

import java.util.HashMap;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 17:21
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

    static int[] preorderstatic;
    static HashMap<Integer, Integer> dic = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        preorderstatic = preorder;

        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }

        return recur(0, 0, inorder.length - 1);
    }

    private static TreeNode recur(int root, int left, int right) {

        if (left > right) return null;  // 递归终止

        TreeNode node = new TreeNode(preorderstatic[root]);  // 根节点

        // 划分根节点、左子树、右子树

        int index = dic.get(preorderstatic[root]);

        node.left = recur(root + 1, left, index - 1);
        node.right = recur(root + index - left + 1, index + 1, right);

        return node;
    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};


    }
}
