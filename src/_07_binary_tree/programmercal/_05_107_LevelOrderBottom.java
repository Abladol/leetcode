package _07_binary_tree.programmercal;

import java.util.*;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * Last Modified:
 * @date 2024/11/7 12:56
 */
public class _05_107_LevelOrderBottom {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        int size = 1;
        TreeNode node;
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                node = queue.pollFirst();
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
                temp.add(node.val);
            }
            res.add(temp);
            size = queue.size();
        }

        List<List<Integer>> reverseResult = new ArrayList<>(res.size());
        for (int i = res.size() - 1; i >= 0; i--) {
            reverseResult.add(res.get(i));
        }
        return reverseResult;
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n6, n7);
        TreeNode n1 = new TreeNode(1, n2, n3);

        List<List<Integer>> lists = levelOrderBottom(n1);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}

