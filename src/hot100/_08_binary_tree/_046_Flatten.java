package hot100._08_binary_tree;

import hot100.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你二叉树的根结点 root ，请你将它展开为一个单链表：  展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * Last Modified:
 * @date 2025/2/12 14:11
 */
public class _046_Flatten {
    /*
    我的思路：维护一个队列存放树的节点，然后构造一个树，空间上没有创建新的树
     */
    public void flatten(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        retrace(root,deque);
        while (!deque.isEmpty()){
            TreeNode node = deque.pollFirst();
            node.left=null;
            node.right=deque.peekFirst();
        }
    }
    public void retrace(TreeNode root, Deque<TreeNode> deque){
        if(root==null){
            return;
        }
        //中
        deque.offerLast(root);
        retrace(root.left,deque);
        retrace(root.right,deque);
    }

    /*
    自己的另一个想法：自己的思路遍历和重组树分开了，但实际上我们可以合在一起,不使用递归，使用迭代即可，但是这两种方法的时间复杂度和空间复杂度都是n
     */
    public void flatten2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if(root!=null) {
            deque.offerLast(root);
        }
        //维护一个栈，然后按照取中放右左的顺序，取出后就是前序遍历，还要额外维护一个pre指向之前的一个节点
        TreeNode pre = new TreeNode(-1);
        while (!deque.isEmpty()){
            TreeNode cur = deque.pollLast();
            pre.left=null;
            pre.right=cur;
            if(cur.right!=null) deque.offerLast(cur.right);
            if(cur.left!=null) deque.offerLast(cur.left);
            pre=cur;
        }
    }

    /*
    空间复杂度为1的解法：满足要求其实很简单，我们先考虑根节点，根节点的右子树应该都在左子树所有节点的后面，所以找到左子树里的最右节点，将根节点的右子树连接在这个
    最右节点的右边，这个时候，根节点只有左子树了，然后将左子树换到右子树上，依次遍历下去，左子树不为空就这样执行
     */
    public void flatten3(TreeNode root) {
        while (root != null) {
            TreeNode move = root.left;
            while (move != null && move.right != null) {
                move = move.right;
            }
            if (move != null) {
                move.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t4 = new TreeNode(4, t3, t6);
        TreeNode t1 = new TreeNode(1);
        TreeNode t5 = new TreeNode(2, t1, t4);

        _046_Flatten flatten = new _046_Flatten();
        flatten.flatten2(t5);
        System.out.println(t5.toString());
    }
}

