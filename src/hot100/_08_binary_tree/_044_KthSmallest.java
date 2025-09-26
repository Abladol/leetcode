package hot100._08_binary_tree;

import hot100.TreeNode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 * <p>
 * Last Modified:
 * @date 2025/2/11 15:09
 */
public class _044_KthSmallest {
    /*
    我的思路；使用递归和中序遍历，设计一个计数器，k减到0那么就是答案
     */
    int count = 0;
    int res = -1;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int l = kthSmallest(root.left, k);
        count++;
        if (k == count) {
            res = root.val;
        }
        //如果找到了，可以提前返回
        if (l >= 0) return l;
        int r = kthSmallest(root.right, k);
        if (r >= 0) return r;
        return res;
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t4 = new TreeNode(4, t3, t6);
        TreeNode t1 = new TreeNode(1);
        TreeNode t5 = new TreeNode(2, t1, t4);

        _044_KthSmallest kthSmallest = new _044_KthSmallest();
        System.out.println(kthSmallest.kthSmallest(t5, 4));
    }
}

