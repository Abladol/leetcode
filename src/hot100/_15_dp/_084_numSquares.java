package hot100._15_dp;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * Last Modified:
 * @date 2025/2/18 20:45
 */
public class _084_numSquares {
    /*
    我的思路：这是一个背包问题，背包容量为n，物品有1,4,9....价值也是这么多
     */
    public int numSquares(int n) {
        n++;
        //dp数组
        int[] dp = new int[n];
        //初始化
        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }
        //遍历物品
        for (int i = 1; i < Math.sqrt(n); i++) {
            //遍历背包
            for (int j = 0; j < n; j++) {
                if (j >= i * i) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        _084_numSquares numSquares = new _084_numSquares();
        System.out.println(numSquares.numSquares(13));
    }
}

