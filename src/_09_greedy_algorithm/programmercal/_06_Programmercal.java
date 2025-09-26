package _09_greedy_algorithm.programmercal;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 */
public class _06_Programmercal {
    /**
     * 找到每天的利润，将每天正利润相加即可
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int allProfit = 0;
        int[] dayProfit = new int[prices.length - 1];
        for (int i = 0; i < prices.length-1; i++) {
            dayProfit[i] = prices[i+1]-prices[i];
        }
        for (int j : dayProfit) {
            if (j > 0) {
                allProfit += j;
            }
        }
        return allProfit;
    }

    public static void main(String[] args) {
        _06_Programmercal programmercal = new _06_Programmercal();
        System.out.println(programmercal.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

    }
}
