package hot100._08_binary_tree;

import hot100.TreeNode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * Last Modified:
 * @date 2025/2/10 19:17
 */
public class _039_IsSymmetric {
    /*
    我的思路：分为两边，左边的树翻转后如果和右边的树一样就是
     */
    public boolean isSymmetric(TreeNode root) {
        TreeNode left = invert(root.left);
        return compare(left, root.right);
    }

    public boolean compare(TreeNode l,TreeNode r){
        //这个是判断他们不同时为空的
        if((l == null) ^ (r == null)){
            return false;
        }else if(l==null && r==null){
            return true;
        }
        boolean left = compare(l.left, r.left);
        boolean right = compare(l.right,r.right);
        if(!left || !right || l.val!=r.val){
            return false;
        }else {
            return true;
        }
    }

    public TreeNode invert(TreeNode node){
        if(node==null){
            return null;
        }
        TreeNode left = invert(node.left);
        TreeNode right = invert(node.right);
        node.left=right;
        node.right=left;
        return node;
    }

    /*
    官方解法：他的思路是依次遍历，分为左树和右树，用两个指针分别对比，不一致就不对称
     */
    public boolean isSymmetric2(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


    public static void main(String[] args) {
        TreeNode t4=new TreeNode(4);
        TreeNode t2=new TreeNode(2,t4,null);
        TreeNode t6=new TreeNode(6);
        TreeNode t5=new TreeNode(4,null,null);
        TreeNode t3=new TreeNode(2,null,t5);
        TreeNode t1=new TreeNode(1,t2,t3);

        _039_IsSymmetric isSymmetric = new _039_IsSymmetric();
        System.out.println(isSymmetric.isSymmetric(t1));
        System.out.println(isSymmetric.isSymmetric(t2));
    }

}

