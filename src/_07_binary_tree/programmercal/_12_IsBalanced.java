package _07_binary_tree.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉树，判断它是否是高度平衡的二叉树。  本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * Last Modified:
 * @date 2024/11/11 13:59
 */
public class _12_IsBalanced {

    public static boolean isBalanced(TreeNode root) {
        return countDepth(root) != -1;
    }


    //计算高度，后序遍历
    public static int countDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countDepth(root.left);
        // -1 表示已经不是平衡二叉树了，否则返回值是以该节点为根节点树的高度
        if (left == -1) {
            return -1;
        }
        int right = countDepth(root.right);
        // -1 表示已经不是平衡二叉树了，否则返回值是以该节点为根节点树的高度
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) < 2) {
            return Math.max(left, right) + 1;
        } else {
            // -1 表示已经不是平衡二叉树了，否则返回值是以该节点为根节点树的高度
            return -1;
        }
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n4 = new TreeNode(4,n6,null);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, null, null);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(isBalanced(n1));
    }
}

