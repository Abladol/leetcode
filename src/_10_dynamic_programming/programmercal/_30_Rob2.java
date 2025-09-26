package _10_dynamic_programming.programmercal;

import java.lang.reflect.Array;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个
 * 房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 * <p>
 * Last Modified:
 * @date 2024/11/2 12:08
 */
public class _30_Rob2 {
    /**
     * 第一家和最后一家不能一起偷，所以可以分情况讨论，当我们考虑偷第一家，最后一家就绝对不偷
     * 第二种情况：考虑从第二家开始偷到最后一家，第一家绝对不偷，比较他们两个那个价值最高就好了
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }else if (nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        //第一种情况
        int val1 = rob_n1(nums,0,nums.length-1);
        int val2 = rob_n1(nums,1,nums.length);
        return Math.max(val1,val2);
    }

    public static int rob_n1(int[] nums,int start, int end) {
        int size =nums.length-1;
        int[] dp = new int[size];
        //初始化：
        dp[0]=nums[start];
        dp[1]=Math.max(nums[start],nums[start+1]);

        //递推
        for (int i = 2; i <size; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i+start]);
        }
        return dp[size-1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3}));
    }

}

