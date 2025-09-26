package _10_dynamic_programming.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。  你只能选择 某一天 买入这只股票，并选择在
 * 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。  返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * Last Modified:
 * @date 2024/11/5 12:15
 */
public class _32_MaxProfit {
    public static int maxProfit(int[] prices) {
        //dp[i][0]表示第i天不持有股票
        int[][] dp =new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] =  -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //第i如果持有股票的收益就是：要么昨天就持有，那么不变，要么今天开始 买的
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
            //第i不持有股票的收益，要么之前就没有，要么今天卖了
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}

