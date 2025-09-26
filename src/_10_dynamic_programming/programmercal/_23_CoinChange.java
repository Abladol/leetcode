package _10_dynamic_programming.programmercal;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 *
 * @author AiJun
 * @version 1.0
 * @date 2024/10/30 17:55
 */
public class _23_CoinChange {
    /**
     * 完全背包，组合问题
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        if (amount == 0) {
            return 0;
        }
        //遍历物品
        for (int i = 0; i < coins.length; i++) {
            //遍历空间
            for (int j = 1; j < amount + 1; j++) {
                //如果背包能装下物品
                if (j >= coins[i]) {
                    if ((j - coins[i] == 0 || dp[j - coins[i]] != 0)) {
                        if (dp[j] != 0) {
                            dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);  //方法数=装上这个 物品dp[j-i]
                        } else {
                            dp[j] = dp[j - coins[i]] + 1;
                        }
                    }
                }
            }
        }

        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2, 5, 10, 1}, 27));
    }
}
