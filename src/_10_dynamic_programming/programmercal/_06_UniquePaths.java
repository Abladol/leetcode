package _10_dynamic_programming.programmercal;

import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（
 * 问总共有多少条不同的路径？
 */
public class _06_UniquePaths {
    public int uniquePaths(int m, int n) {
        //1.初始化
        int[][] dp = new int[m][n];
        //第一行和第一列都赋值为1
        for (int[] x : dp) {
            x[0]=1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        //2.递推，每个单元的值是左边的上面的值相加
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

    //状态压缩版本
    public int uniquePaths1(int m, int n) {
        // 在二维dp数组中，当前值的计算只依赖正上方和正左方，因此可以压缩成一维数组。
        int[] dp = new int[n];
        // 初始化，第一行只能从正左方跳过来，所以只有一条路径。
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i ++) {
            // 第一列也只有一条路，不用迭代，所以从第二列开始
            for (int j = 1; j < n; j ++) {
                dp[j] += dp[j - 1]; // dp[j] = dp[j] (正上方)+ dp[j - 1] (正左方)
            }
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        _06_UniquePaths uniquePaths = new _06_UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 4));
    }
}
