package _07_binary_tree.programmercal;

import java.util.Arrays;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。  一般来说，删除节点可分为两个步骤：  首先找到需要删除的节点； 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 $O(h)$，h 为树的高度。
 * <p>
 * Last Modified:
 * @date 2024/11/22 12:02
 */
public class _30_DeleteNode {
    /*
    我的思路：先找到要删除的节点
    找到其删除节点的右孩子的最左侧节点作为删除节点左孩子的父节点，如果右孩子为空直接让父节点作为左孩子的父节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        //找到这个节点，不会遍历到空节点的
        if (root.val == key) {
            //右孩子不空，右孩子肯定比左孩子大，右孩子的最左叶子节点作为左孩子的父节点
            if (root.right != null) {
                findLeftNode(root.right).left=root.left;
                return root.right;
            }else return root.left;
        }
        else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else {
            root.left=deleteNode(root.left,key);
        }
        return root;
    }

    public TreeNode findLeftNode(TreeNode node) {
        while (node != null) {
            if (node.left != null) {
                node = node.left;
            }else return node;
        }
        return null;
    }

       public static void main(String[] args) {
        TreeNode n5 = new TreeNode(48);
        TreeNode n6 = new TreeNode(2, null, null);
        TreeNode n4 = new TreeNode(10, n6, null);
        TreeNode n7 = new TreeNode(99);
        TreeNode n2 = new TreeNode(13, n4, null);
        TreeNode n3 = new TreeNode(49, n5, n7);
        TreeNode n1 = new TreeNode(21, n2, n3);
        _30_DeleteNode deleteNode = new _30_DeleteNode();
        TreeNode node = deleteNode.deleteNode(n1, 211);
        System.out.println(Arrays.toString(_02_3_InorderTraversal.inorderTraversal(node).toArray()));
    }


}

