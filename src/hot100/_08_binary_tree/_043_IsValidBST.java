package hot100._08_binary_tree;

import hot100.TreeNode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：  节点的左 子树 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * Last Modified:
 * @date 2025/2/11 14:45
 */
public class _043_IsValidBST {
    /*
    我的思路：首先明确一点，左子树是BST,右子树也是BST，合起来并不一定是BST，因为右子树中所有的节点值要都大于左子树节点值
    觉得可以使用左中右遍历，记录上一次遍历的值，确保当前节点的值大于上一次遍历的结果
     */
    //节点的值范围是-2^31 <= Node.val <= 2^31 - 1，所以要使用long
    long preValue = Long.MIN_VALUE;
    /*
    我的思路比答案的写法更易懂，和代码随想录是一样的
     */
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        //left
        boolean left = isValidBST(root.left);
        //middle
        boolean flag = left && root.val>preValue;
        preValue=root.val;
        boolean right = isValidBST(root.right);
        return flag && right;
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t4 = new TreeNode(4, t3, t6);
        TreeNode t1 = new TreeNode(1);
        TreeNode t5 = new TreeNode(5, t1, t4);
        _043_IsValidBST isValidBST = new _043_IsValidBST();
        System.out.println(isValidBST.isValidBST(t5));
    }
}

