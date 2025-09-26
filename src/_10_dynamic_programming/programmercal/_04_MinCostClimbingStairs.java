package _10_dynamic_programming.programmercal;

/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
public class _04_MinCostClimbingStairs {

    /**
     * dp[i]的定义：到达第i台阶所花费的最少体力为dp[i]。
     * 确定递推公式
     * 可以有两个途径得到dp[i]，一个是dp[i-1] 一个是dp[i-2]。
     * dp[i - 1] 跳到 dp[i] 需要花费 dp[i - 1] + cost[i - 1]。
     * dp[i - 2] 跳到 dp[i] 需要花费 dp[i - 2] + cost[i - 2]。
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 3) {
            return Math.min(cost[0], cost[1]);
        }
        //1.初始化
        int[] dp = new int[cost.length+1];
        for (int i = 2; i < cost.length+1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        _04_MinCostClimbingStairs minCostClimbingStairs = new _04_MinCostClimbingStairs();
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(new int[]{10,15,20}));
    }
}
