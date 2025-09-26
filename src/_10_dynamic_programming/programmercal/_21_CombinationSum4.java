package _10_dynamic_programming.programmercal;

/**
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 * 请注意，顺序不同的序列被视作不同的组合。
 * @author AiJun
 * @version 1.0
 * @date 2024/10/29 13:44
 */
public class _21_CombinationSum4 {
    /**
     * 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
     * 如果求排列数就是外层for遍历背包，内层for循环遍历物品。
     * @param nums
     * @param target
     * @return
     */
    public static int combinationSum4(int[] nums, int target) {
        int[] dp =new int[target + 1];
        //初始化
        dp[0]=1;

        //先遍历背包
        for (int i = 0; i < target+1; i++) {
            //再遍历物品
            for (int j = 0; j < nums.length; j++) {
                //如果物品放得下
                if(nums[j]<=i){
                    dp[i]=dp[i-nums[j]]+dp[i];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
