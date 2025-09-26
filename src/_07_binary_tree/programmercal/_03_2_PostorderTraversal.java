package _07_binary_tree.programmercal;


import java.util.*;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 中右左和左右中是完全相反的，前序遍历是中左右，改变代码就可以得到中右左，最后反转数组即可
 */
public class _03_2_PostorderTraversal {
    //左右中
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if(root==null){
            return res;
        }
        stack.offerLast(root);
        while (!stack.isEmpty()){
            TreeNode mid = stack.pollLast();
            res.add(mid.val);
            if(mid.left!=null){
                stack.offerLast(mid.left);
            }
            if(mid.right!=null){
                stack.offerLast(mid.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2,n4,n5);
        TreeNode n3 = new TreeNode(3,n6,n7);
        TreeNode n1 = new TreeNode(1,n2,n3);
        System.out.println(Arrays.toString(postorderTraversal(n1).toArray()));
    }
}
