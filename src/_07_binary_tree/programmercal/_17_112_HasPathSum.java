package _07_binary_tree.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。  说明: 叶子节点是指没有子节点的节点。  示例: 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * Last Modified:
 * @date 2024/11/12 10:33
 */
public class _17_112_HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return traverse(root, targetSum);
    }

    public boolean traverse(TreeNode node, int num) {
        //回溯条件，这里面的节点的值可以是负值，所以不能加判断num小于0提前回溯
        if (node == null ) {
            return false;
        }
        //不要去累加然后判断是否等于目标和，那么代码比较麻烦，可以用递减，让计数器count初始为目标和，然后每次减去遍历路径节点上的数值。
        num = num - node.val;
        //提前中止条件，当他为叶子节点，并且num为0，返回true
        if(node.left==null && node.right==null&& num==0)return true;
        boolean left = traverse(node.left, num);
        boolean right = traverse(node.right, num);
        return left || right;
    }

    public static void main(String[] args) {
        _17_112_HasPathSum hasPathSum = new _17_112_HasPathSum();
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n4 = new TreeNode(4, n6, null);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n7, null);
        TreeNode n1 = new TreeNode(1, n2, n3);
        System.out.println(hasPathSum.hasPathSum(n4, 10));
    }
}

