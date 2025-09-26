package _10_dynamic_programming.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * Last Modified:
 * @date 2024/11/6 11:00
 */
public class _35_MaxProfit3 {
    /**
     * 相比之前的问题，这里面最大只允许交易两次，那么就要增加更多的状态
     * dp[i][0]：第一次持有股票的最大收益
     * dp[i][1]：第一次不持有股票的最大收益
     * dp[i][2]：第二次持有股票的最大收益
     * dp[i][3]：第二次不持有股票的最大收益
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        //初始化注意一个点，不用担心第一天买不到两次，我们可以当天买当天卖着也属于一次买卖。
        int[][] dp = new int[prices.length][4];
        dp[0][0]=-prices[0];
        dp[0][2]=-prices[0];

        for (int i = 1; i < prices.length; i++) {
            //第一次持有股票：一种情况是之前就持有，一种情况是今天刚买的，注意这里只能是刚买的就是-价格，之前是没有买过的，这样也就确保了，只会买两次
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            //第一次不持有股票：一种情况是之前就卖掉了，一种情况是今天卖的
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
            //第二次持有股票，一种情况是之前就买了，而且是第二次买的，一种情况是当天买的，当天买的还要基于第一次卖出的状态，因为这个是基于上一次的，所以这样确保了只会买两次
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]-prices[i]);
            //第二次不持有
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]+prices[i]);
        }
        return dp[prices.length-1][3];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}

