package hot100._08_binary_tree;

import hot100.TreeNode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 * <p>
 * Last Modified:
 * @date 2025/2/10 19:53
 */
public class _040_DiameterOfBinaryTree {
    /*
    我的思路：我觉得像是求左子树最大高度加上右子树最大高度，注意要依次递归计算，并且用一个值保存最大直径,所以要使用后序遍历
     */
    private int maxRadis;

    public int diameterOfBinaryTree(TreeNode root) {
        System.out.println(Math.max(maxRadis,retrace(root)));
        int n = retrace(root);
        System.out.println(Math.max(maxRadis,n));
        return Math.max(maxRadis, n);
    }

    public int retrace(TreeNode node){
        if (node == null) {
            return -1;
        }
        //left
        int l = retrace(node.left);
        int r = retrace(node.right);
        maxRadis=Math.max(maxRadis,l+r+2);
        return Math.max(l+1,r+1);
    }

    public static void main(String[] args) {
        TreeNode t3=new TreeNode(4);
        TreeNode t4=new TreeNode(2);
        TreeNode t2=new TreeNode(6,t3,t4);
        TreeNode t5=new TreeNode(5);
        TreeNode t1=new TreeNode(3,t2,t5);
        _040_DiameterOfBinaryTree diameterOfBinaryTree=new _040_DiameterOfBinaryTree();
        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(t1));
    }
}

