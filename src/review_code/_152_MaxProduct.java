package review_code;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。  测试用例的答案是一个 32-位 整数。
 * <p>
 * Last Modified:
 * @date 2025/10/12 16:31
 */
public class _152_MaxProduct {
    //绝对值大就是大，即使是负数一旦再乘以一个负数就会很大
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = Math.max(Integer.MIN_VALUE, max);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>0){
                max = Math.max(nums[i],max *nums[i]);
                min = Math.min(nums[i],min*nums[i]);
            }else {
                int temp = max;
                max = Math.max(nums[i],min *nums[i]);
                min = Math.min(nums[i],temp*nums[i]);
            }
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        _152_MaxProduct maxProduct = new _152_MaxProduct();
        System.out.println(maxProduct.maxProduct(new int[]{-1, -2, -9, -6}));
    }
}

