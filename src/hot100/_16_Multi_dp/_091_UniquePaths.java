package hot100._16_Multi_dp;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。  问总共有多少条不同的路径？
 * <p>
 * Last Modified:
 * @date 2025/2/24 20:48
 */
public class _091_UniquePaths {
    /*
    我的思路：多维动态规划，可以记录每个点位的有几种路径
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //第一行只能一直向右得到，第一列也是只能一直向右得到
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        _091_UniquePaths uniquePaths = new _091_UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 7));
    }
}

