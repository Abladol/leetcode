package _10_dynamic_programming.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。  设计一个算法来计算你所能获取的
 * 最大利润。你最多可以完成 k 笔交易。  注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * Last Modified:
 * @date 2024/11/6 15:03
 */
public class _36_MaxProfit4 {
    /**
     * dp[天数][买卖]
     * dp[0][0]:持有
     * dp[0][1]：不持有
     * dp[0][2]：持有
     * dp[0][3]：不持有
     * ·······
     * dp[0][2*k-1]：不持有
     *
     * @param k
     * @param prices
     * @return
     */
    public static int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k];
        for (int i = 0; i < k; i++) {
            dp[0][2 * i] = -prices[0];
        }

        //递归
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + prices[i]);
            for (int j = 2; j < 2 * k; j = j + 2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}

