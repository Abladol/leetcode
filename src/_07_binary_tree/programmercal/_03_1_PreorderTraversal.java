package _07_binary_tree.programmercal;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class _03_1_PreorderTraversal {
    //中左右
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if(root==null){return res;}
        stack.offerLast(root);
         while (!stack.isEmpty()){
             TreeNode mid =stack.pollLast();
             res.add(mid.val);
             if(mid.right!=null){
                 stack.offerLast(mid.right);
             }
             if(mid.left!=null){
                 stack.offerLast(mid.left);
             }
         }
         return res;
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2,n4,n5);
        TreeNode n3 = new TreeNode(3,n6,n7);
        TreeNode n1 = new TreeNode(1,n2,n3);
        System.out.println(Arrays.toString(preorderTraversal(n4).toArray()));
    }
}
