package _10_dynamic_programming.programmercal;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class _09_NumTrees {

    public int numTrees(int n) {
        //1.初始化
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        //递推
        /*
        有三个节点的时候，考虑三种情况
        1️⃣：1为根节点，那么1左边就是0，dp[0]，右边就是两个节点，dp[2]，所有情况为dp[0]*dp[2]
        2️⃣：2为根节点，那么2左边就是1，dp[1]，右边就是1，dp[1]，所有情况为dp[1]*dp[1]
        3️⃣：3为根节点，那么3左边就是2个节点，dp[2]，右边就是0，所有情况为dp[2]*dp[0]
         */
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                //左边就是dp[J-1]，右边就是dp[i-j]
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        _09_NumTrees numTrees = new _09_NumTrees();
        System.out.println(numTrees.numTrees(5));
    }
}
