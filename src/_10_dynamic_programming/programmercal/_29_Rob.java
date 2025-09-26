package _10_dynamic_programming.programmercal;

import java.util.Arrays;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * Last Modified:
 * @date 2024/11/1 17:13
 */
public class _29_Rob {
    public static int rob(int[] nums) {
        int size = nums.length;
        int[] dp=new int[size];
        //初始化，前两个选取最大值，递推从 第3个开始
        if(size==1){
            return nums[0];
        }
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        //遍历物品，就是房间
        for (int i = 2; i < size; i++) {
            //递推：如果我不偷第i家，那么考虑到i-1家就可以，如果 偷 ，只能考虑到i-2家
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[size-1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,1,1,2}));
    }
}

