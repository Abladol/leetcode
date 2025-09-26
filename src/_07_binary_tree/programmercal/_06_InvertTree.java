package _07_binary_tree.programmercal;

import java.util.Arrays;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 翻转一棵二叉树。
 * <p>
 * Last Modified:
 * @date 2024/11/7 13:49
 */
public class _06_InvertTree {
    //递归遍历，交换孩子，前序后后序遍历都可以，中序遍历是不行的
    public static TreeNode invertTree(TreeNode root) {
        return traverse(root);
    }


    //后序遍历，左右中
    public static TreeNode traverse(TreeNode node) {
        //中止条件
        if (node == null) {
            return null;
        }
        TreeNode left = traverse(node.left);
        TreeNode right = traverse(node.right);
        //中节点，交换孩子
        node.left = right;
        node.right = left;
        return node;
    }


    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n6, n7);
        TreeNode n1 = new TreeNode(1, n2, n3);

        TreeNode res = traverse(n1);

        System.out.println(Arrays.toString(_02_3_InorderTraversal.inorderTraversal(res).toArray()));
    }
}

