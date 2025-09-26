package hot100._05_ordinary_array;

import java.util.Arrays;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * Last Modified:
 * @date 2025/1/5 14:40
 */
public class _016_ProductExceptSelf {
    /*
    本题没有想到好的思路，最后借助提示：可以利用前缀积（prefix product）和后缀积（suffix product）分别计算结果。
    具体思路是先遍历两次数组，一次计算前缀积，一次计算后缀积，并将两者结合起来得到最终结果。
     */
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        int[] res = new int[nums.length];
        pre[0] = 1;
        post[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
            post[i] = post[i - 1] * nums[nums.length - i];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre[i] * post[nums.length - 1 - i];
        }
        return res;
    }

    public static void main(String[] args) {
        _016_ProductExceptSelf productExceptSelf = new _016_ProductExceptSelf();
        System.out.println(Arrays.toString(productExceptSelf.productExceptSelf(new int[]{-1, 0, 3, 4})));
    }
}

