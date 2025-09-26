package hot100._08_binary_tree;

import hot100.TreeNode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * Last Modified:
 * @date 2025/2/13 12:14
 */
public class _049_LowestCommonAncestor {
    /*
    我的思路：采用后序遍历，存在下面情况，左右孩子各是一个寻找的节点，当前节点就是答案，左或者右有一个，自身有一个，那么自己就是答案，然后有一个标记为标记是否找到依次递归上传
    这个标记就是找到p或者q任意一个就是true。
     */
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       retrace(root,p,q);
       return ans;
    }

    public boolean retrace(TreeNode node,TreeNode p ,TreeNode q){
        if(node==null) return false;
        boolean left = retrace(node.left ,p,q);
        boolean right = retrace(node.right,p,q);
        //这个只能进入一次，不然ans会被覆盖，恰好也只会进入一次,找到答案后，后面的分支永远都是false，不会满足下面任一条件
        if((left&&right) || ((left||right) && (node==p||node==q))){
            ans=node;
            return true;
        }else{
            return left||right||node==p||node==q;
        }
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t4 = new TreeNode(4, t3, t6);
        TreeNode t1 = new TreeNode(1);
        TreeNode t5 = new TreeNode(5, t1, t4);
        _049_LowestCommonAncestor lowestCommonAncestor = new _049_LowestCommonAncestor();
        System.out.println(lowestCommonAncestor.lowestCommonAncestor(t5, t1, t3).toString());
    }
}

