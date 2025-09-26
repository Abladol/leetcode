package _10_dynamic_programming.programmercal;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * <p>
 * 返回 你可以获得的最大乘积
 */
public class _08_IntegerBreak {

    public int integerBreak(int n) {
        //1.初始化
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        //2.递推
        for (int i = 2; i < n + 1; i++) {
            //对此时的i值进行拆分，分成可以分成两份，j和i-j，或者分成多分，j和dp[i-j]
            for (int j = 1; j < i; j++) {
                int temp = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(temp,dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        _08_IntegerBreak integerBreak = new _08_IntegerBreak();
        System.out.println(integerBreak.integerBreak(12));

    }
}
