package _10_dynamic_programming.programmercal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，
 * 每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一
 * 天晚上被打劫，房屋将自动报警。  计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * Last Modified:
 * @date 2024/11/5 10:26
 */
public class _31_Rob3 {

    /**
     * 这里面要从下向上递推，也就是后序遍历，因为如果你从上向下遍历，最后会有很多个节点，你无法判断，从下向上遍历最后都会归于一个根节点
     *
     * @param root
     * @return
     */
    public static int rob(TreeNode root) {
        //dp数组只有两种状态，偷还是不偷
        int[] dp = action(root);
        return Math.max(dp[0],dp[1]);
    }


    public static int[] action(TreeNode treeNode) {
        int[] dp = new int[2];
        int[] dp1 = new int[2];
        int[] dp2 = new int[2];

        //左孩子
        if (treeNode.left != null) {
            dp1 = action(treeNode.left);
        }
        //右孩子
        if (treeNode.right != null) {
            dp2 = action(treeNode.right);
        }
        //当前节点
        //偷当前节点
        dp[1] = dp1[0]+dp2[0]+treeNode.val;
        //不偷
        dp[0]=Math.max(dp1[0],dp1[1])+Math.max(dp2[0],dp2[1]);
        return dp;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class BinaryTreeBuilder {
        public static TreeNode buildTree(Integer[] array) {
            if (array == null || array.length == 0) {
                return null;
            }

            TreeNode root = new TreeNode(array[0]);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int i = 1;
            while (i < array.length) {
                TreeNode current = queue.poll();

                if (array[i] != null) {
                    current.left = new TreeNode(array[i]);
                    queue.offer(current.left);
                }
                i++;

                if (i < array.length && array[i] != null) {
                    current.right = new TreeNode(array[i]);
                    queue.offer(current.right);
                }
                i++;
            }

            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = BinaryTreeBuilder.buildTree(new Integer[]{3,4,5,1,3,null,1});
        System.out.println(rob(tree));
    }
}

