package _07_binary_tree.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。  完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2^h 个节点。
 * <p>
 * Last Modified:
 * @date 2024/11/11 12:56
 */
public class _11_CountNodes {

    //介绍满二叉树，如果是满二叉树，深度为n，那么节点的个数就是x^n-1
    public static int countNodes(TreeNode root) {
        return traverse(root);
    }

    //后序遍历
    public static int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isFullBinaryTree(root) != 0) {
            return (int) isFullBinaryTree(root);
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        return left + right + 1;
    }


    public static double isFullBinaryTree(TreeNode root) {
        int left = 0;
        int right = 0;
        TreeNode node = root;
        while (node.left != null) {
            left++;
            node = node.left;
        }
        node = root;
        while (node.right != null) {
            right++;
            node = node.right;
        }
        if (left == right) {
            return Math.pow(2, left + 1)-1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n6, null);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(traverse(n1));
    }
}

