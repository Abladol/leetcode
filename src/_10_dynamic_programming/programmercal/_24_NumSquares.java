package _10_dynamic_programming.programmercal;

/**
 * @author AiJun
 * @version 1.0
 * @date 2024/10/31 9:48
 */
public class _24_NumSquares {
    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        //需要最小的个数，那么dp初始化就设置一个很大的值
        int[] dp =  new int[n+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i]=Integer.MAX_VALUE-1;
        }
        //完全背包问题，组合问题
        //遍历物品
        for (int i = 1; i <= Math.sqrt(n); i++) {
            //遍历背包
            for (int j = 1; j < n + 1; j++) {
                //如果能装下
                if(j>=Math.pow(i,2)){
                    dp[j]=Math.min(dp[(int) (j-Math.pow(i, 2))]+1,dp[j]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(16));
    }
}
