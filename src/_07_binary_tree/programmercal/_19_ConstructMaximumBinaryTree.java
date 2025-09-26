package _07_binary_tree.programmercal;

import java.util.Arrays;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：  二叉树的根是数组中的最大元素。 左子树是通过数组中最大值
 * 左边部分构造出的最大二叉树。 右子树是通过数组中最大值右边部分构造出的最大二叉树。 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * <p>
 * Last Modified:
 * @date 2024/11/16 12:28
 */
public class _19_ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int temp = -1;
        int maxnumIndex = 0;
        //中止条件
        if (nums.length == 0) {
            return null;
        }
        //先找到最大的数
        for (int i = 0; i < nums.length; i++) {
            if (temp < nums[i]) {
                temp = nums[i];
                maxnumIndex = i;
            }
        }
        //分左右子树，最大值不在最右边，最大值在最右边，会溢出maxnumIndex + 1
        int[] left = Arrays.copyOfRange(nums, 0, maxnumIndex);
        int[] right;
        if (maxnumIndex != nums.length-1) {
            right = Arrays.copyOfRange(nums, maxnumIndex + 1, nums.length);
        } else {
            right =new int[]{};
        }
        TreeNode node = new TreeNode(nums[maxnumIndex]);
        node.left=constructMaximumBinaryTree(left);
        node.right=constructMaximumBinaryTree(right);
        return node;
    }

    public static void main(String[] args) {
        _19_ConstructMaximumBinaryTree constructMaximumBinaryTree = new _19_ConstructMaximumBinaryTree();
        TreeNode node = constructMaximumBinaryTree.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        System.out.println(_02_3_InorderTraversal.inorderTraversal(node));
    }
}

