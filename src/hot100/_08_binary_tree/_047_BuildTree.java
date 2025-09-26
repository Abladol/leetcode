package hot100._08_binary_tree;

import hot100.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * Last Modified:
 * @date 2025/2/12 14:51
 */
public class _047_BuildTree {
    /*
    个人思路：前序遍历的第一个就是根节点，后面可以分为两个部分，第一部分是左子树的前序遍历，第二部分是右子树的前序遍历
    中序遍历如果找到根节点，直接分为两部分，左边是左子树，右边是右子树

    官方答案的思路一致，我们的思路也可以优化
    第一，可以不使用list，使用hash进行一次映射即可，节约空间和时间
    第二，进行递归的时候，没必要找到左数组和右数组，传入数组的开始和结束位置即可（理不清可以传入数组，因为比较容易理解）
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre = tolist(preorder);
        List<Integer> inor = tolist(inorder);
        TreeNode root = retrace(pre, inor);
        return root;
    }

    public TreeNode retrace(List<Integer> pre,List<Integer> inorder){
        //当list长度为0，说明遍历完了
        if(pre.size()==0){
            return null;
        }
        //pre的第一个就是根节点
        int root = pre.get(0);
        TreeNode rootNode = new TreeNode(root);
        //inorder寻找，并分为两份
        int index = inorder.indexOf(root);
        List<Integer> leftInorder = inorder.subList(0,index);
        List<Integer> rightInorder = inorder.subList(index+1,inorder.size());
        List<Integer> leftPre=pre.subList(1,1+leftInorder.size());
        List<Integer> rightPre = pre.subList(1+leftPre.size(),pre.size());
        TreeNode left = retrace(leftPre,leftInorder);
        TreeNode right = retrace(rightPre,rightInorder);
        rootNode.left=left;
        rootNode.right=right;
        return rootNode;
    }

    public List<Integer> tolist(int[] a){
        List<Integer> res = new ArrayList<>();
        for (int x : a) {
            res.add(x);
        }
        return res;
    }

    public static void main(String[] args) {
        _047_BuildTree buildTree = new _047_BuildTree();
        TreeNode node = buildTree.buildTree(new int[]{1,2}, new int[]{2,1});
        System.out.println(node.toString());
    }
}

