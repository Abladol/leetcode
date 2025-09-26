package _07_binary_tree.programmercal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */
public class _02_2_PostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursion(root, res);
        return res;
    }

    //左右中
    public static List<Integer> recursion(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        recursion(root.left, res);
        recursion(root.right, res);
        res.add(root.val);
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

        System.out.println(Arrays.toString(postorderTraversal(n1).toArray()));
    }
}
