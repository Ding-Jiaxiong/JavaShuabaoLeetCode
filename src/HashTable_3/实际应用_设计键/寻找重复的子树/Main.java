package HashTable_3.实际应用_设计键.寻找重复的子树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    // 深搜
    static Map<String, Integer> map = new HashMap<>();  // 子树的序列化作为键，出现次数作为值
    static List<TreeNode> res = new ArrayList<>();  // 结果列表，存储重复的子树根节点

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        dfs(root);  // 对 root 进行深度优先搜索

        return res;
    }

    private static String dfs(TreeNode root) {

        if (root == null) return " ";

        StringBuilder sb = new StringBuilder();

        sb.append(root.val).append("_");
        sb.append(dfs(root.left)).append(dfs(root.right));

        String key = sb.toString();

        map.put(key, map.getOrDefault(key, 0) + 1);

        if (map.get(key) == 2) res.add(root);

        // 最后的 map 是这样的
//        {"3_2_4_ 4_": 1, "4_": 3, "2_4_": 2, "1_2_4 3_2_4 4_": 1}
        // 所以最后的答案是 4 2

        return key;
    }


    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node5.left = node7;
        node3.right = node6;

        for (TreeNode node : findDuplicateSubtrees(node1)) {
            System.out.print(node.val + " ");
        }

    }
}
