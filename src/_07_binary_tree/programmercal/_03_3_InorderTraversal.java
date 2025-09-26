package _07_binary_tree.programmercal;


import java.util.*;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class _03_3_InorderTraversal {
    /**
     * 中序遍历：前中后，整体思路是入栈的顺序是先中节点后左节点，然后弹出左节点，检查有无右节点，有右节点继续入栈中左，依次类推
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        //栈的初始化
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        //保证入栈的顺序是中左，
        while (!stack.isEmpty() || node != null) {
            if (node!= null) {
                stack.offerLast(node);
                node = node.left;
            } else {
                //如果这个结点没有右节点，弹出去的就是左边的节点，下一步继续弹出，这个时候如果这个节点还有右节点呢，那么弹出的节点其实是中间节点，那么马上让他的右节点入栈
                node = stack.pollLast();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n6, n7);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(Arrays.toString(inorderTraversal(n1).toArray()));
    }
}
