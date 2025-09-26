package _07_binary_tree.programmercal;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 根据一棵树的中序遍历与后序遍历构造二叉树。  注意: 你可以假设树中没有重复的元素。
 * <p>
 * Last Modified:
 * @date 2024/11/13 9:53
 */
public class _18_BuildTree {
    private TreeNode result;

    /*
    中序遍历：左中右：可以根据根节点确定左树的范围和右树的范围
    后序遍历：左右中，最后一个节点 就是根节点
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //递归中止条件
        if (inorder.length == 0) {
            return null;
        }
        TreeNode res = new TreeNode();
        //先找到根节点
        int root = postorder[postorder.length - 1];
        //在中序遍历中分为左树和右树
        int rootIndex;//左边就是左树右边就是中树
        for (rootIndex = 0; rootIndex < inorder.length; rootIndex++) {
            if (inorder[rootIndex] == root)
                break;
        }
        //中序遍历左树
        int[] leftTreeInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        //中序遍历右树
        int[] rightTreeInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        //后序遍历左树
        int[] leftTreePostorder = Arrays.copyOfRange(postorder, 0, leftTreeInorder.length);
        //后序遍历右树
        int[] rightTreePostorder = Arrays.copyOfRange(postorder, leftTreeInorder.length, leftTreeInorder.length+rightTreeInorder.length);
        //递归，获取左树根节点和右树根节点
        TreeNode leftRoot = buildTree(leftTreeInorder, leftTreePostorder);
        TreeNode rightRoot = buildTree(rightTreeInorder, rightTreePostorder);
        res.val=root;
        res.left=leftRoot;
        res.right=rightRoot;
        return res;
    }

    public static void main(String[] args) {
        _18_BuildTree buildTree = new _18_BuildTree();
        TreeNode res = buildTree.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(res.toString());
    }

}

