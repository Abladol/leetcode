package hot100._08_binary_tree;

import hot100.TreeNode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。  路径和 是路径中各节点值的总和。  给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * Last Modified:
 * @date 2025/2/16 15:34
 */
public class _050_MaxPathSum {
    /*
    看了答案后的思路：从底部开始，更新每个节点的贡献度，如果孩子节点的贡献度是正的，那就取最大的，如果不是正的就不取,然后加上自己的贡献度进行返回，此外每次都要sauna最大路径和
    这里是规定每条路径都是经过自己节点的，自然就是左边贡献+自己贡献+右边贡献
     */
    static int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        retrace(root);
        return res;
    }

    public int retrace(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //开始处理，孩子节点，使用后序遍历,返回的值可能是负值，如果是负值，应该是不要的
        int left = Math.max(retrace(root.left), 0);
        int right = Math.max(retrace(root.right), 0);

        //以该节点为根节点，最大路径和就是左边+自己+右边，可能这里有疑惑，如果自己这个节点值很小，加在一起没有左右单独的大，其实这是会发生的，但是在左节点里面递归的时候
        //这个值已经被加到res中了
        int temp = root.val + left + right;
        res = Math.max(res, temp);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(-10);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        _050_MaxPathSum maxPathSum = new _050_MaxPathSum();
        System.out.println(maxPathSum.maxPathSum(t3));
    }
}



