package hot100._08_binary_tree;

import hot100.TreeNode;

import java.util.*;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 \
 * （即逐层地，从左到右访问所有节点）。
 * <p>
 * Last Modified:
 * @date 2025/2/11 13:59
 */
public class _041_LevelOrder {
    /*
    我的思路：一层一层遍历，可以维护一个队列，队列里面就是一层，然后将每一层的左右子树继续放进队列，就是下一层,此外我们要记录每一层节点的数量
     */
    Deque<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    int count = 0;
    int num = 0;

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root != null) {
            queue.offerLast(root);
        }
        count = 1;
        while (!queue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            while (count > 0) {
                TreeNode node = queue.pollFirst();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offerLast(node.left);
                    num++;
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                    num++;
                }
                count--;
            }
            count = num;
            num = 0;
            //添加这一层的结果
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2, t4, null);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5, null, t6);
        TreeNode t3 = new TreeNode(3, t5, null);
        TreeNode t1 = new TreeNode(1, t2, t3);

        _041_LevelOrder levelOrder = new _041_LevelOrder();
        List<List<Integer>> lists = levelOrder.levelOrder(t1);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.stream().mapToInt(Integer::intValue).toArray()));
        }
    }

}

