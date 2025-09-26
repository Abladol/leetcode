package _07_binary_tree.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉树，判断其是否是一个有效的二叉搜索树。  假设一个二叉搜索树具有如下特征：  节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * Last Modified:
 * @date 2024/11/19 10:04
 */
public class _23_IsValidBST {
    private long value= Long.MIN_VALUE;
    /*
    陷阱1
    不能单纯的比较左节点小于中间节点，右节点大于中间节点就完事了。
    我们要比较的是 左子树所有节点小于中间节点，右子树所有节点大于中间节点。所以以上代码的判断逻辑是错误的。
     */
    public boolean isValidBST(TreeNode root) {
        //使用中序遍历，BST的结果的递增的
        if(root == null){
            return true;
        }
        //左节点
        boolean left = isValidBST(root.left);
        if(root.val>value){
            value=root.val;
        }else {return false;}
        boolean right = isValidBST(root.right);

        return left && right;

    }

     public static void main(String[] args) {
         TreeNode n5 = new TreeNode(50);
         TreeNode n6 = new TreeNode(2, null, null);
         TreeNode n4 = new TreeNode(10, n6, null);
         TreeNode n7 = new TreeNode(70);
         TreeNode n2 = new TreeNode(12, n4, n5);
         TreeNode n3 = new TreeNode(73, n7, null);
         TreeNode n1 = new TreeNode(1, n2, n3);

         _23_IsValidBST isValidBST = new _23_IsValidBST();
         System.out.println(isValidBST.isValidBST(n1));


     }
}

