package _07_binary_tree.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：  节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。 左右子树也必须是二叉搜索树。
 * <p>
 * Last Modified:
 * @date 2024/11/27 13:00
 */
public class _33_ConvertBST {
    public TreeNode pre = new TreeNode(0);
    //右中左遍历顺序
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        //右
        TreeNode right = convertBST(root.right);
        //中：处理
        node.val = node.val + pre.val;
        node.right = right;
        pre=node;
        //左
        node.left = convertBST(root.left);
        return node;
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(1, null, null);
        TreeNode n4 = new TreeNode(2, n6, null);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(3, n4, null);
        TreeNode n3 = new TreeNode(6, n5, n7);
        TreeNode n1 = new TreeNode(4, n2, n3);

        _33_ConvertBST convertBST = new _33_ConvertBST();
        TreeNode node = convertBST.convertBST(n1);
        System.out.println(_02_3_InorderTraversal.inorderTraversal(node));
    }
}

