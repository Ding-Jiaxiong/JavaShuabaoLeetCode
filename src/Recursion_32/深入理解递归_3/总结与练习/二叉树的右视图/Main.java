package Recursion_32.深入理解递归_3.总结与练习.二叉树的右视图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * JavaShuabaoLeetCode
 *
 * Main
 *
 * @author Ding Jiaxiong
 * @Date 2024/8/23 18:13
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

    // 基本思路就是取层序遍历的最后一个值组成答案
    public static List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>(); // 使用队列保存节点以便逐层遍历二叉树

        ArrayList<Integer> res = new ArrayList<>();  // 结果列表

        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) { // 队列不为空时，执行循环遍历

            ArrayList<Integer> tmp = new ArrayList<>();  // 存储当前层的所有节点值

            for (int i = queue.size(); i > 0; i--) { // 对当前层的节点进行遍历

                TreeNode node = queue.poll();  // 从队列中取出节点并将其值添加到临时列表中

                tmp.add(node.val);

                if (node.left != null) // 如果左子节点存在，将其加入队列
                    queue.add(node.left);
                if (node.right != null) // 如果右子节点存在，将其加入队列
                    queue.add(node.right);
            }

            res.add(tmp.get(tmp.size() - 1));  //将当前层的最后一个节点值添加到结果列表中
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
