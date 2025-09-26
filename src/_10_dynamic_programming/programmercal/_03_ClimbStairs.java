package _10_dynamic_programming.programmercal;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class _03_ClimbStairs {
    public int climbStairs(int n) {
        if (n < 3) {
        return n;
        }
        //1.初始化
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        //2.推导
        for (int i = 3; i < n+1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        _03_ClimbStairs climbStairs = new _03_ClimbStairs();
        System.out.println(climbStairs.climbStairs(2));
    }
}
