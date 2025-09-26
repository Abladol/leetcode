package _07_binary_tree.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * <p>
 * Last Modified:
 * @date 2024/11/19 12:41
 */
public class _24_GetMinimumDifference {
    //防止做差后溢出
    private int result = Integer.MAX_VALUE/2;
    private int value = Integer.MIN_VALUE/2;

    //搜索二叉树中序遍历是递增的
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return result;
        }
        getMinimumDifference(root.left);
        if (Math.abs(root.val - value) < result) {
            result = Math.abs(root.val - value);
        }
        value=root.val;
        getMinimumDifference(root.right);
        return result;
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(12);
        TreeNode n6 = new TreeNode(2, null, null);
        TreeNode n4 = new TreeNode(10, n6, null);
        TreeNode n7 = new TreeNode(49);
        TreeNode n2 = new TreeNode(0, null, null);
        TreeNode n3 = new TreeNode(48, n5, n7);
        TreeNode n1 = new TreeNode(1, n2, n3);
        _24_GetMinimumDifference getMinimumDifference = new _24_GetMinimumDifference();
        System.out.println(getMinimumDifference.getMinimumDifference(n1));
    }

}

