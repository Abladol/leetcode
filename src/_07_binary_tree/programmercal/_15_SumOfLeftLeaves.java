package _07_binary_tree.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 计算给定二叉树的所有左叶子之和。
 * <p>
 * Last Modified:
 * @date 2024/11/12 9:33
 */
public class _15_SumOfLeftLeaves {

    //左叶子节点：某节点的左孩子不为空，该孩子的左右孩子都为空，那么该孩子就是左叶子节点
    public int sumOfLeftLeaves(TreeNode root) {
         return traverse(root);
    }

    public int traverse(TreeNode node) {
        //中止条件
        if (node == null) {
            return 0;
        }
        int left = traverse(node.left);
        int right = traverse(node.right);
        if (node.left != null && node.left.left == null && node.left.right == null){
            return node.left.val+left+right;
        }else return left+right;
    }

    public static void main(String[] args) {
        _15_SumOfLeftLeaves sumOfLeftLeaves = new _15_SumOfLeftLeaves();
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n4 = new TreeNode(4, n6, null);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n7, null);
        TreeNode n1 = new TreeNode(1, n2, n3);
        System.out.println(sumOfLeftLeaves.traverse(n1));
    }
}

