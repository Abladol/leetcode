package _07_binary_tree.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。  百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * Last Modified:
 * @date 2024/11/21 10:29
 */
public class _26_LowestCommonAncestor {

    //有一个注意的点，就是祖先节点一点存在，如果当前节点不是p或者q，不用处理，或者返回本节点就可以，一直返回就可以了
    //一定要从下向上遍历，所以要使用后序遍历，
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //中止条件
        if (root == null) {
            return null;
        }
        //使用后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //判断，如果
        if ((left != null && right != null) || root == p || root == q) {
            return root;
        }else if(left!=null){
            return left;
        } else return right;

    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(48);
        TreeNode n6 = new TreeNode(2, null, null);
        TreeNode n4 = new TreeNode(10, n6, null);
        TreeNode n7 = new TreeNode(49);
        TreeNode n2 = new TreeNode(1, n4, null);
        TreeNode n3 = new TreeNode(49, n5, n7);
        TreeNode n1 = new TreeNode(1, n2, n3);

        _26_LowestCommonAncestor lowestCommonAncestor = new _26_LowestCommonAncestor();
        System.out.println(lowestCommonAncestor.lowestCommonAncestor(n1, n3, n7).val);
    }


}

