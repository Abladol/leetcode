package hot100._08_binary_tree;

import hot100.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * <p>
 * Last Modified:
 * @date 2025/2/10 18:33
 */
public class _036_InorderTraversal {
    /*
    我的思路：中序遍历：左中右
     */
    private List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        reTrace(root);
        return res;
    }

    public void reTrace(TreeNode node){
        if(node==null){
            return;
        }
        //左
        if(node.left!=null){
            inorderTraversal(node.left);
        }
        //中
        res.add(node.val);
        //右
        if(node.right!=null){
            inorderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode t4=new TreeNode(4);
        TreeNode t2=new TreeNode(2,t4,null);
        TreeNode t6=new TreeNode(6);
        TreeNode t5=new TreeNode(5,null,t6);
        TreeNode t3=new TreeNode(3,t5,null);
        TreeNode t1=new TreeNode(1,t2,t3);
        _036_InorderTraversal inorderTraversal = new _036_InorderTraversal();
        List<Integer> list = inorderTraversal.inorderTraversal(t1);
        System.out.println(Arrays.toString(list.toArray()));
    }
}

