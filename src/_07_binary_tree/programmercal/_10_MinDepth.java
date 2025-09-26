package _07_binary_tree.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉树，找出其最小深度。  最小深度是从根节点到最近叶子节点的最短路径上的节点数量。  说明: 叶子节点是指没有子节点的节点。
 * <p>
 * Last Modified:
 * @date 2024/11/11 12:01
 */
public class _10_MinDepth {
    public static int minDepth(TreeNode root) {
        return traverse(root, 0);
    }


    //深度，前序遍历
    public static int traverse(TreeNode root, int n) {
        if (root == null) {
            return n;
        }
        n++;
        int left = traverse(root.left, n);
        int right = traverse(root.right, n);
        //如果左右孩子有一个不是空，那就不是叶子节点
        if (root.left != null && root.right != null) {
            return Math.min(left, right);
        } else {
            return Math.max(left, right);
        }
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2, n4, null);
        TreeNode n3 = new TreeNode(3, n6, null);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(minDepth(n1));
    }
}

