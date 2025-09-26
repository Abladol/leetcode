package _07_binary_tree.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。  百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * Last Modified:
 * @date 2024/11/21 15:40
 */
public class _28_LowestCommonAncestor {
    /*
    当我们从上向下去递归遍历，第一次遇到 cur节点是数值在[q, p]区间中，那么cur就是 q和p的最近公共祖先。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //中止条件
        if (root == null) {
            return null;
        }
        //p不一定小于q
        if ((p.val <= root.val && root.val <= q.val) || (p.val>=root.val && root.val >= q.val)){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null) return left;
        else return right;
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(48);
        TreeNode n6 = new TreeNode(2, null, null);
        TreeNode n4 = new TreeNode(10, n6, null);
        TreeNode n7 = new TreeNode(99);
        TreeNode n2 = new TreeNode(13, n4, null);
        TreeNode n3 = new TreeNode(49, n5, n7);
        TreeNode n1 = new TreeNode(21, n2, n3);

        _28_LowestCommonAncestor lowestCommonAncestor = new _28_LowestCommonAncestor();
        System.out.println(lowestCommonAncestor.lowestCommonAncestor(n1, n3, n2).val);

    }
}

