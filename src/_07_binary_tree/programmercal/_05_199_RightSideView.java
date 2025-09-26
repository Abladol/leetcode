package _07_binary_tree.programmercal;

import java.util.*;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * Last Modified:
 * @date 2024/11/7 13:06
 */
public class _05_199_RightSideView {
    //错误解法：因为可能左边右3层，右边只有2层，应该能看到左边的第三层，但是这个算法是看不到的
//    public static List<Integer> rightSideView(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        TreeNode node = root;
//        while (node != null) {
//            res.add(node.val);
//            if (node.right != null) {
//                node = node.right;
//            } else {
//                node = node.left;
//            }
//        }
//        return res;
//    }

    //组层遍历，只找每一层的最后一个元素+
    public static List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        int size = 1;
        TreeNode node = root;
        queue.offerLast(node);
        while (!queue.isEmpty()) {
            if (size == 1) {
                res.add(queue.peek().val);
            }
            node = queue.pollFirst();
            if(node.left!=null){queue.offerLast(node.left);}
            if(node.right!=null){queue.offerLast(node.right);}
            size--;
            if(size==0){
                size=queue.size();
            }
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

        System.out.println(Arrays.toString(rightSideView(n1).toArray()));
    }
}

