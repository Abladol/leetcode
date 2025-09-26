package _07_binary_tree.programmercal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉树，在树的最后一行找到最左边的值。
 * <p>
 * Last Modified:
 * @date 2024/11/12 10:02
 */
public class _16_FindBottomLeftValue {

    //层序遍历
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        int count = 0;
        TreeNode node = root;
        queue.offerLast(root);
        int num = 1;
        int res = 0;
        while (!queue.isEmpty()) {
            res = queue.peekFirst().val;
            for (int i = 0; i < num; i++) {
                node = queue.pollFirst();
                if (node.left != null) {
                    queue.offerLast(node.left);
                    count++;
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                    count++;
                }
            }
            num = count;
            count = 0;
        }
        return res;
    }

    //上面答案不够简洁，忘记了层序遍历的写法，下面是标准答案
    public int findBottomLeftValue2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _16_FindBottomLeftValue findBottomLeftValue = new _16_FindBottomLeftValue();
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n4 = new TreeNode(4, n6, null);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n7, null);
        TreeNode n1 = new TreeNode(1, n2, n3);
        System.out.println(findBottomLeftValue.findBottomLeftValue2(n1));
    }
}

