package _07_binary_tree.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * <p>
 * Last Modified:
 * @date 2024/11/16 13:32
 */
public class _22_SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        //中止条件
        if (root == null) {
            return null;
        }
        if (val == root.val) return root;
        else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
           return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(50);
        TreeNode n6 = new TreeNode(2, null, null);
        TreeNode n4 = new TreeNode(10, n6, null);
        TreeNode n7 = new TreeNode(70);
        TreeNode n2 = new TreeNode(12, n4, n5);
        TreeNode n3 = new TreeNode(73, n7, null);
        TreeNode n1 = new TreeNode(61, n2, n3);

        _22_SearchBST searchBST = new _22_SearchBST();
        TreeNode node = searchBST.searchBST(n1, 10);
        System.out.println(_02_1_PreorderTraversal.preorderTraversal(node));
    }
}

