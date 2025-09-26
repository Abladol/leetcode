package _07_binary_tree.programmercal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _02_3_InorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursion(root, res);
        return res;
    }
    

    //左中右
    public static List<Integer> recursion(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        recursion(root.left, res);
        res.add(root.val);
        recursion(root.right, res);
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

        System.out.println(Arrays.toString(inorderTraversal(n1).toArray()));
    }
}
