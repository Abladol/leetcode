package _10_dynamic_programming.programmercal;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 * @author AiJun
 * @date 2024/10/29 13:43
 * @version 1.0
 */

public class _19_Change {
    public static int change(int amount, int[] coins) {
        //物品：金币；重量：金币的值，价值：金币的值，背包空间：总金额
        int[] dp = new int[amount+1];
        //初始化
        dp[0]=1;
        //先遍历物品
        for (int i = 0; i <coins.length; i++) {
            //遍历空间
            for (int j = 0; j < amount + 1; j++) {
                //如果背包能装下当前物品
                if(j>=coins[i]){
                    //用这个物品的方式+不用这个物品的方式
                    dp[j] = dp[j-coins[i]]+dp[j];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(0, new int[]{1,2,5}));
    }
}
