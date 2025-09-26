package hot100._14_greedy_algorithm;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * Last Modified:
 * @date 2025/2/17 17:09
 */
public class _077_MaxProfit {
    /*
    我的思路：只能买卖一次，其实很简单，最低点买入，最高点卖出，找到最低点，不断更新，然后假设今天卖出就是最大利润，不断贪心，利润不断更新
     */
    public int maxProfit(int[] prices) {
        int low = 0;
        if(prices.length>0){
            low=prices[0];
        }
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            res = Math.max(res, prices[i] - low);
        }
        return res;
    }

    public static void main(String[] args) {
        _077_MaxProfit maxProfit = new _077_MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}

