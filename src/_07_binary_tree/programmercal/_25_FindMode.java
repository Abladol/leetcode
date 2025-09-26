package _07_binary_tree.programmercal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * Last Modified:
 * @date 2024/11/19 13:29
 */
public class _25_FindMode {
    private List<Integer> result = new ArrayList<>();
    private int count = 0;
    private int maxCount = 0;
    private TreeNode pre = null;
    private TreeNode cur = null;

    public int[] findMode(TreeNode root) {
        retrace(root);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void retrace(TreeNode root) {
        if (root == null) return;
        retrace(root.left);
        cur = root;
        //刚刚遍历第一个节点
        if (pre == null) count = 1;
        //当前节点与前一个节点值相同
        else if (pre.val == cur.val) {
            count++;
        }
        //当前节点与前一个节点值不相同
        else count = 1;

        if (count == maxCount) {
            result.add(cur.val);
        } else if (count > maxCount) {
            result.clear();
            result.add(cur.val);
            maxCount = count;
        }
        pre = cur;
        retrace(root.right);
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(48);
        TreeNode n6 = new TreeNode(2, null, null);
        TreeNode n4 = new TreeNode(10, n6, null);
        TreeNode n7 = new TreeNode(49);
        TreeNode n2 = new TreeNode(1, null, null);
        TreeNode n3 = new TreeNode(48, n5, n7);
        TreeNode n1 = new TreeNode(1, n2, n3);
        _25_FindMode findMode = new _25_FindMode();
        System.out.println(Arrays.toString(findMode.findMode(n1)));
    }
}

