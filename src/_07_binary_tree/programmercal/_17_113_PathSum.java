package _07_binary_tree.programmercal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。  叶子节点 是指没有子节点的节点。
 * <p>
 * Last Modified:
 * @date 2024/11/12 10:57
 */

public class _17_113_PathSum {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum);
        return result;
    }

    public TreeNode traverse(TreeNode root, int num) {
        //中止条件
        if (root == null) {
            return null;
        }
        res.add(root.val);
        num = num - root.val;
        TreeNode left = traverse(root.left, num);
        TreeNode right = traverse(root.right, num);

        //满足条件
        if (num == 0&&root.left == null&&root.right == null) {
            result.add(new ArrayList<>(res));
        }
        res.remove(res.size() - 1);
        //回溯
        return null;

    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n4 = new TreeNode(4, n6, null);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n7, null);
        TreeNode n1 = new TreeNode(1, n2, n3);

        _17_113_PathSum pathSum = new _17_113_PathSum();
        System.out.println(Arrays.toString(pathSum.pathSum(n1, 11).toArray()));
    }
}

