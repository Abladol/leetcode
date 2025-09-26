package _07_binary_tree.programmercal;

import java.util.*;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * <p>
 * Last Modified:
 * @date 2024/11/7 11:15
 */
public class _04_3_InorderTraversal {
    /**
     * 中序遍历：左中右，入栈顺序：右中左
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node;
        if(root == null){
            return Collections.emptyList();
        }
        //先讲根节点放入
        stack.offerLast(root);
        //总体思路是人为遍历节点左中右，将需要处理的节点打上标记null
        while (!stack.isEmpty()) {
            node=stack.pollLast();
            if(node!=null){
                if(node.right!=null){stack.offerLast(node.right);}
                stack.offerLast(node);
                stack.offerLast(null);
                if(node.left != null){stack.offerLast(node.left);}
            }else {
                res.add(stack.pollLast().val);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2, n4,null);
        TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(Arrays.toString(inorderTraversal(n1).toArray()));
    }
}

