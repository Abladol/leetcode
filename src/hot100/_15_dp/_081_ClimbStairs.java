package hot100._15_dp;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * Last Modified:
 * @date 2025/2/17 20:09
 */
public class _081_ClimbStairs {
    /*
    我的思路：（n方法）=（n-1方法）+（n-2方法），我可以再n-2走两步，n-1走一步，其实就是他们两种方法和相加，可能你有疑惑，这直接会不会有重复，很显然不会，因为从n-2出到n的方法
    不经过n-1，所以肯定不重复，可能你会觉得会不会有遗漏，也不会，没别的方法 了，如果你说n-2处先到n-1再到n，这其实包含在n-1直接到n了
     */
    /*
    我们用 f(x) 表示爬到第 x 级台阶的方案数，考虑最后一步可能跨了一级台阶，也可能跨了两级台阶，所以我们可以列出如下式子：
    f(x)=f(x−1)+f(x−2)
    它意味着爬到第 x 级台阶的方案数是爬到第 x−1 级台阶的方案数和爬到第 x−2 级台阶的方案数的和。很好理解，因为每次只能爬 1 级或 2 级，
    所以 f(x) 只能从 f(x−1) 和 f(x−2) 转移过来，而这里要统计方案总数，我们就需要对这两项的贡献求和。

     */
    public int climbStairs(int n) {
        if (n < 2) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        _081_ClimbStairs climbStairs = new _081_ClimbStairs();
        System.out.println(climbStairs.climbStairs(3));
    }
}

