package hot100._08_binary_tree;

import hot100.TreeNode;

import java.util.Arrays;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵平衡二叉搜索树。
 * <p>
 * Last Modified:
 * @date 2025/2/11 14:17
 */
public class _042_SortedArrayToBST {
    /*
    我的思路：使用归并，将数组一分为二，依次一分为二，最后分别构成左右子树，返回根节点
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1) {
            return null;
        }
        int i = 0;
        int j = 0;
        while (j < nums.length && j + 1 < nums.length) {
            j = j + 2;
            i++;
        }
        //此时数组被分为两部分
        int[] left = Arrays.copyOfRange(nums, 0, i);
        int[] right = Arrays.copyOfRange(nums, i + 1, nums.length);
        TreeNode l = sortedArrayToBST(left);
        TreeNode r = sortedArrayToBST(right);
        TreeNode root = new TreeNode(nums[i]);
        root.left = l;
        root.right = r;
        return root;
    }

    /*
    官方思路：自己的思路没有问题，部分可以优化，我的思路采用快慢指针找中点，但是实际上对于数组可以直接找到中点
     */
    public TreeNode sortedArrayToBST2(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        _042_SortedArrayToBST sortedArrayToBST = new _042_SortedArrayToBST();
        TreeNode node = sortedArrayToBST.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(node.toString());
    }
}

