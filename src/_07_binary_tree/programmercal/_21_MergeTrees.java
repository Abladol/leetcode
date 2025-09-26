package _07_binary_tree.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。  你需要将他们合并为一个新的二叉树。
 * 合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * Last Modified:
 * @date 2024/11/16 13:19
 */
public class _21_MergeTrees {

    //对节点是否为空的判断过于复杂了
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        //使用前序遍历，哪种遍历方式都可以
        TreeNode mergeNode = new TreeNode();
        mergeNode.val = (root1 != null ? root1.val : 0) + (root2 != null ? root2.val : 0);
        mergeNode.left=mergeTrees(root1!=null?root1.left:null,root2!=null?root2.left:null);
        mergeNode.right=mergeTrees(root1!=null?root1.right:null,root2!=null?root2.right:null);
        return mergeNode;
    }

    //标准答案
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);
        return root1;
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n4 = new TreeNode(4, n6, null);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n7, null);
        TreeNode n1 = new TreeNode(1, n2, n3);

        TreeNode m5 = new TreeNode(5);
        TreeNode m6 = new TreeNode(6, null, null);
        TreeNode m4 = new TreeNode(4, m6, null);
        TreeNode m7 = new TreeNode(7);
        TreeNode m2 = new TreeNode(2, m4, m5);
        TreeNode m3 = new TreeNode(3, m7, null);
        TreeNode m1 = new TreeNode(1, m3, m2);

        _21_MergeTrees mergeTrees = new _21_MergeTrees();
        TreeNode mergedTrees = mergeTrees.mergeTrees(n1, m1);
        System.out.println(_02_1_PreorderTraversal.preorderTraversal(mergedTrees));
    }
}

