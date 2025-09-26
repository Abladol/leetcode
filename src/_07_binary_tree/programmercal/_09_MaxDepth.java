package _07_binary_tree.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉树，找出其最大深度。  二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。  说明: 叶子节点是指没有子节点的节点。
 * <p>
 * Last Modified:
 * @date 2024/11/9 13:12
 */
public class _09_MaxDepth {

    //官方解法：
    /*
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
     */

    private static int num;
    public static int maxDepth(TreeNode root) {
        return depthCount(root, 0);

    }

    public static int depthCount(TreeNode node,int depth){
        //中止
        if(node==null){
            return depth;
        }
        int realDepth = depth+1;
        int leftDepth = depthCount(node.left, realDepth);
        int rightDepth = depthCount(node.right,realDepth);
        num=Math.max(leftDepth,rightDepth);
        return num;
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6,n4,null);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2,null,null);
        TreeNode n3 = new TreeNode(3, n6, n7);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(maxDepth(n5));
    }
}

