package hot100._15_dp;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * Last Modified:
 * @date 2025/2/18 21:24
 */
public class _085_CoinChange {
    /*
    我的思路：这是一个最小组合问题，所以物品的排序随便，那么就要先遍历物品再遍历背包，并且初始化必须是很大的值
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //初始化
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        //先遍历物品
        for (int i = 0; i < coins.length; i++) {
            //再遍历背包
            for (int j = 0; j < amount + 1; j++) {
                //选择当前硬币与不选择当前硬币，注意如果不选择当前硬币无法组合那就不能替换
                if (j >= coins[i] && dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        _085_CoinChange coinChange = new _085_CoinChange();
        System.out.println(coinChange.coinChange(new int[]{2}, 3));
    }
}

