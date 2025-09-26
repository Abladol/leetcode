package _07_binary_tree.programmercal;

import java.util.Arrays;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
 * 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。  注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 * <p>
 * Last Modified:
 * @date 2024/11/21 16:05
 */
public class _29_InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        //找到叶子节点了
       if(root==null){
           return new TreeNode(val);
       }
       if(val<root.val){
           root.left=insertIntoBST(root.left,val);
       }else {
           root.right=insertIntoBST(root.right,val);
       }
       return root;
    }


    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(48);
        TreeNode n6 = new TreeNode(2, null, null);
        TreeNode n4 = new TreeNode(10, n6, null);
        TreeNode n7 = new TreeNode(99);
        TreeNode n2 = new TreeNode(13, n4, null);
        TreeNode n3 = new TreeNode(49, n5, n7);
        TreeNode n1 = new TreeNode(21, n2, n3);
        _29_InsertIntoBST insertIntoBST = new _29_InsertIntoBST();
        TreeNode node = insertIntoBST.insertIntoBST(n1, 3);
        System.out.println(Arrays.toString(_02_3_InorderTraversal.inorderTraversal(node).toArray()));
    }
}

