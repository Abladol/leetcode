package _07_binary_tree.programmercal;

import java.util.*;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * Last Modified:
 * @date 2024/11/7 11:51
 */
public class _05_102_LevelOrder {
    /**
     * 思路：构建一个队列，逐行遍历，记录每一行有多少个节点即可
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>>  res = new ArrayList<>();
        TreeNode node;
        int size = 1;
        queue.offerLast(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                node = queue.pollFirst();
                if(node.left!=null){
                    queue.offerLast(node.left);
                }
                if (node.right !=null){
                    queue.offerLast(node.right);
                }
                temp.add(node.val);
            }
            res.add(temp);
            size=queue.size();
        }
        return  res;
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3,n6, n7);
        TreeNode n1 = new TreeNode(1, n2, n3);

        List<List<Integer>> lists = levelOrder(n1);
        for (List<Integer> list : lists){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}

