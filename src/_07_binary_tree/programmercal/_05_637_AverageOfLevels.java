package _07_binary_tree.programmercal;

import java.util.*;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * <p>
 * Last Modified:
 * @date 2024/11/7 13:27
 */
public class _05_637_AverageOfLevels {
    public static List<Double> averageOfLevels(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        int size = 1;
        TreeNode node = root;
        queue.offerLast(node);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                node=queue.pollFirst();
                temp.add(node.val);
                if(node.left!=null){queue.offerLast(node.left);}
                if(node.right!=null){queue.offerLast(node.right);}
            }
            size=queue.size();
            res.add(Arrays.stream(temp.stream().mapToDouble(Integer::doubleValue).toArray()).sum() /temp.size());
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n6, n7);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(Arrays.toString(averageOfLevels(n1).toArray()));
    }
}

