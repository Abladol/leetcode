package _07_binary_tree.programmercal;

import java.util.Arrays;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。  本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * Last Modified:
 * @date 2024/11/24 14:07
 */
public class _32_SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        int middle = nums.length/2;
        TreeNode root = new TreeNode(nums[middle]);
        int[] left = Arrays.copyOfRange(nums,0,middle);
        int[] right = Arrays.copyOfRange(nums,middle+1,nums.length);
        root.left= sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);
        return root;
    }


    public static void main(String[] args) {
        _32_SortedArrayToBST sortedArrayToBST = new _32_SortedArrayToBST();
        TreeNode node = sortedArrayToBST.sortedArrayToBST(new int[]{});
        System.out.println(_02_3_InorderTraversal.inorderTraversal(node));
    }
}

