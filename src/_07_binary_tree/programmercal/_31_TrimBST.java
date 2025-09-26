package _07_binary_tree.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 * <p>
 * Last Modified:
 * @date 2024/11/22 12:42
 */
public class _31_TrimBST {

    /*
    todo：比代码随想录的方法思路更清晰，采用后续遍历，
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        TreeNode left = trimBST(root.left, low, high);
        TreeNode right = trimBST(root.right, low, high);
        //左右孩子是新的了，可能是null，也可能是之前的，相当于更新自己的左右孩子，如果自己满足要求，直接返回
        root.left = left;
        root.right = right;
        if (root.val >= low && root.val <= high) {
            return root;
        }
        //自己不符合要求，肯定存在一种情况，左右孩子有一个满足或者都不满足，如果有一个满足，那个返回这个孩子就可以，如果都不满足返回null，绝对不可能出现，孩子满足，自己不满足
        if (left != null) return left;
        else return right;
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(48);
        TreeNode n6 = new TreeNode(2, null, null);
        TreeNode n4 = new TreeNode(10, n6, null);
        TreeNode n7 = new TreeNode(99);
        TreeNode n2 = new TreeNode(13, n4, null);
        TreeNode n3 = new TreeNode(49, n5, n7);
        TreeNode n1 = new TreeNode(21, n2, n3);
        _31_TrimBST trimBST = new _31_TrimBST();
        TreeNode node = trimBST.trimBST(n1, 11, 48);
        System.out.println(_02_3_InorderTraversal.inorderTraversal(node));
    }
}

