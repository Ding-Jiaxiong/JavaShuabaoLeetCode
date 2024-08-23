package Recursion_32.深入理解递归_3.总结与练习.从中序与后序遍历序列构造二叉树;

import java.util.HashMap;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 17:32
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

    // 打印二叉树的函数
    public static void printTree(TreeNode root) {
        printTree(root, 0, "H", 17);
    }

    // 递归打印树的结构
    private static void printTree(TreeNode node, int height, String to, int len) {
        if (node == null) return;

        // 递归打印右子树
        printTree(node.right, height + 1, "v", len);

        // 打印当前节点的值及其方向
        String val = to + node.val + to;
        int leftLen = (len - val.length()) / 2;
        int rightLen = len - val.length() - leftLen;
        val = getSpace(leftLen) + val + getSpace(rightLen);
        System.out.println(getSpace(height * len) + val);

        // 递归打印左子树
        printTree(node.left, height + 1, "^", len);
    }

    // 获取指定数量的空格字符串
    private static String getSpace(int num) {
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < num; i++) {
            space.append(" ");
        }
        return space.toString();
    }


    static int[] postorderstatic;
    static HashMap<Integer, Integer> dic = new HashMap<>();

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        postorderstatic = postorder;

        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }

        return recur(postorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode recur(int root, int left, int right) {

        if (left > right) return null;  // 递归终止

        TreeNode node = new TreeNode(postorderstatic[root]);  // 根节点

        // 划分根节点、左子树、右子树

        int index = dic.get(postorderstatic[root]);

        // 构建右子树和左子树
        node.right = recur(root - 1, index + 1, right);
        node.left = recur(root - (right - index + 1), left, index - 1);

        return node;
    }

    public static void main(String[] args) {

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode treeNode = buildTree(inorder, postorder);

    }
}
