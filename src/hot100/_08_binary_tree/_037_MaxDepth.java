package hot100._08_binary_tree;

import hot100.TreeNode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * Last Modified:
 * @date 2025/2/10 18:52
 */
public class _037_MaxDepth {
    /*
    我的思路：从根节点深度遍历，深度每加一层存起来，依次比较，最好递归结束找到最大值
     */
    private int res=0;
    public int maxDepth(TreeNode root) {
        retrace(root,1);
        return res;
    }

    public void retrace(TreeNode node,int depth){
        if(node==null){
            return;
        }
        retrace(node.left,depth+1);
        //当前节点不为空，比较当前深度
        res= Math.max(depth, res);
        retrace(node.right,depth+1);
    }

    /*
    官方答案：深度优先搜索，从底部开始，每个节点存有左边节点的高度和右边节点的高度，最后取最大值，实际上本题也是求最大高度
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode t4=new TreeNode(4);
        TreeNode t2=new TreeNode(2,t4,null);
        TreeNode t6=new TreeNode(6);
        TreeNode t5=new TreeNode(5,null,t6);
        TreeNode t3=new TreeNode(3,t5,null);
        TreeNode t1=new TreeNode(1,t2,t3);

        _037_MaxDepth maxDepth = new _037_MaxDepth();
        System.out.println(maxDepth.maxDepth(t1));
    }
}

