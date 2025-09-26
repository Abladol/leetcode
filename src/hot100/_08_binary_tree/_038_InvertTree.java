package hot100._08_binary_tree;

import hot100.TreeNode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 * Last Modified:
 * @date 2025/2/10 19:08
 */
public class _038_InvertTree {
    /*
    我的思路：采取后序遍历，依次翻转
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        //left
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode t4=new TreeNode(4);
        TreeNode t2=new TreeNode(2,t4,null);
        TreeNode t6=new TreeNode(6);
        TreeNode t5=new TreeNode(5,null,t6);
        TreeNode t3=new TreeNode(3,t5,null);
        TreeNode t1=new TreeNode(1,t2,t3);

        _038_InvertTree invertTree = new _038_InvertTree();
        System.out.println(invertTree.invertTree(t1).toString());
    }
}

