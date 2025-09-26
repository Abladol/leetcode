package hot100._08_binary_tree;

import hot100.TreeNode;

import java.util.*;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * Last Modified:
 * @date 2025/2/11 15:24
 */
public class _045_RightSideView {
    /*
    我的思路：取层序遍历的最右边一个数即可
     */
    Deque<TreeNode> queue = new LinkedList<>();
    List<Integer> res = new ArrayList<>();
    //每一层节点数
    int num = 0;
    //剩余节点数
    int remainNum = 0;

    public List<Integer> rightSideView(TreeNode root) {
        if (root != null) {
            queue.offerLast(root);
        }
        num = 1;
        while (!queue.isEmpty()) {
            remainNum = num;
            num = 0;
            while (remainNum > 0) {
                TreeNode node = queue.pollFirst();
                if (remainNum == 1) res.add(node.val);
                if (node.left != null) {
                    queue.offerLast(node.left);
                    num++;
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                    num++;
                }
                remainNum--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t4 = new TreeNode(4, t3, t6);
        TreeNode t1 = new TreeNode(1);
        TreeNode t5 = new TreeNode(2, t1, t4);

        _045_RightSideView rightSideView = new _045_RightSideView();
        List<Integer> list = rightSideView.rightSideView(t5);
        System.out.println(Arrays.toString(list.stream().mapToInt(Integer::intValue).toArray()));
    }
}

