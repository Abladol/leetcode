package _07_binary_tree.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * Last Modified:
 * @date 2024/11/9 12:32
 */
public class _08_IsSymmetric {
    public static boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    //比较：左边：左右中遍历，右边：右左中遍历，一一对应比较
    public static boolean compare(TreeNode root1, TreeNode root2) {
        //中止条件
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null ^ root2 == null) {
            return false;
        }
        boolean flag1 = compare(root1.left, root2.right);
        boolean flag2 = compare(root1.right, root2.left);
        if (!flag1 || !flag2) {
            return false;
        } else return root1.val == root2.val;
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(5);
        TreeNode n7 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(2, n6, n7);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(isSymmetric(n1));
    }
}

